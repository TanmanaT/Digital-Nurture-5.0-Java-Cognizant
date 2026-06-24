import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = "spring.main.banner-mode=off")
public class UserRepositoryQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Arrange
        User user1 = new User(1L, "Eve");
        User user2 = new User(2L, "Eve");
        User user3 = new User(3L, "Frank");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Act
        List<User> eves = userRepository.findByName("Eve");

        // Assert
        assertEquals(2, eves.size());
    }
}
