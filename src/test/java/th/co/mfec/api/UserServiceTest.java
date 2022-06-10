package th.co.mfec.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import th.co.mfec.api.model.user.UserRequest;
import th.co.mfec.api.model.user.UserResponse;
import th.co.mfec.api.service.user.UserService;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    interface DataTestCreateUser {
        // String username = "test";
        String username = "green@gmail.com";
        String password = "p@ssword";
    }

    @Test
    void testCreateUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(DataTestCreateUser.username);
        userRequest.setPassword(DataTestCreateUser.password);

        UserResponse userResponse = userService.createUser(userRequest);

        // System.out.println(userResponse.getId());
        // System.out.println(userResponse.getUsername());
        // System.out.println(userResponse.getExpiredDate());

        Assertions.assertNotNull(userResponse);
        Assertions.assertNotNull(userResponse.getId());
        Assertions.assertEquals(DataTestCreateUser.username, userResponse.getUsername());

    }
}
