package tr.com.ege.se.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import tr.com.ege.se.entity.Role;
import tr.com.ege.se.repo.RoleRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        boolean executiveRoleExists = roleRepository.existsByName("ROLE_EXECUTIVE");
        if (!executiveRoleExists) {
            Role executiveRole = new Role();
            executiveRole.setName("ROLE_EXECUTIVE");
            roleRepository.save(executiveRole);
        }
        
        boolean projectManagerRoleExists = roleRepository.existsByName("ROLE_PROJECTMANAGER");
        if (!projectManagerRoleExists) {
            Role projectManagerRole = new Role();
            projectManagerRole.setName("ROLE_PROJECTMANAGER");
            roleRepository.save(projectManagerRole);
        }
        
        boolean teamMemberRoleExists = roleRepository.existsByName("ROLE_TEAMMEMBER");
        if (!teamMemberRoleExists) {
            Role teamMemberRole = new Role();
            teamMemberRole.setName("ROLE_TEAMMEMBER");
            roleRepository.save(teamMemberRole);
        }
        
        boolean internRoleExists = roleRepository.existsByName("ROLE_INTERN");
        if (!internRoleExists) {
            Role internRole = new Role();
            internRole.setName("ROLE_INTERN");
            roleRepository.save(internRole);
        }
    }
}
