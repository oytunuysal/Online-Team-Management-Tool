package tr.com.ege.se.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tr.com.ege.se.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findByName(String name);

    List<User> findByUsernameStartingWithAndOperationTypeIsNotNullAndActiveTrueOrderByIdDesc(String username);

    List<User> findByRoles_NameIn(List<String> roles);

    @Query("select u from User u where u.id = :id")
    Optional<User> getById(long id);

    @Query(value = "select * from User u where u.id = :id", nativeQuery = true)
    Optional<User> getByIdNative(long id);
}
