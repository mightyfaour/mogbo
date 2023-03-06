package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.findAll().size());
    }

}