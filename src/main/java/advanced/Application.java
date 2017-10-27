package advanced;

import advanced.security.Role;
import advanced.security.RolesRepository;
import advanced.security.User;
import advanced.security.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLine(){
        return (args) -> {
            rolesRepository.save(new Role("USER"));
            rolesRepository.save(new Role("ADMIN"));

            User ilia = new User("Ilia", "123456");
            ilia.setRole(rolesRepository.getOne(2L));
            userRepository.save(ilia);
            User dasha = new User("Dasha", "123456");
            dasha.setRole(rolesRepository.getOne(2L));
            userRepository.save(dasha);
            User user = new User("User", "123456");
            user.setRole(rolesRepository.getOne(1L));
            userRepository.save(user);
            user = new User("User2", "123456");
            user.setRole(rolesRepository.getOne(1L));
            userRepository.save(user);

            log.info("Users:");
            userRepository.findAll().forEach(u ->log.info(u.toString()));
        };
    }
}