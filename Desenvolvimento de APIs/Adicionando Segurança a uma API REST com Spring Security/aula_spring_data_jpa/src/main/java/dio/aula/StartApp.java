package dio.aula;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Rey");
        user.setUsername("rey222");
        user.setPassword("123");

        repository.save(user);

        for (User u : repository.findAll()){
            System.out.println(u);
        }
    }
}
