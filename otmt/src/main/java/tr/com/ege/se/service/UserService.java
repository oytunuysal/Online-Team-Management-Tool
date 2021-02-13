package tr.com.ege.se.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tr.com.ege.se.entity.User;
import tr.com.ege.se.model.MyUserDetails;
import tr.com.ege.se.model.UserDTO;
import tr.com.ege.se.repo.RoleRepository;
import tr.com.ege.se.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public User save(UserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(Stream.of(roleRepository.findByName("ROLE_USER")).collect(Collectors.toSet()));
        User savedUser = userRepository.save(user);

        return savedUser;
    }
    
    public List<User> findLikeUsernames(String username) {
        return userRepository.findByUsernameStartingWithAndOperationTypeIsNotNullAndActiveTrueOrderByIdDesc(username);
    }

    public Page<User> findAll(int pageSize, int pageNumber) {
        Pageable paged = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(paged);
    }

    public List<User> findByRoles(List<String> roles) {
        return userRepository.findByRoles_NameIn(roles);
    }

    public Optional<User> findById(long id) {
        return userRepository.getByIdNative(id);
    }
    
    public User findByName(String name){
    	return userRepository.findByName(name);
    }

    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

   

    public User delete(long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setActive(false);
            return userRepository.save(user);

        }
        throw new IllegalArgumentException("User not found");
    }
    
    public User activate(long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setActive(true);
            return userRepository.save(user);

        }
        throw new IllegalArgumentException("User not found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return new MyUserDetails(byUsername.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
