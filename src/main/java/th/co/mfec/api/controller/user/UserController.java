package th.co.mfec.api.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.co.mfec.api.model.common.SuccessResponse;
import th.co.mfec.api.model.user.UserRequest;
import th.co.mfec.api.model.user.UserResponse;
import th.co.mfec.api.service.user.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    // http://localhost:8080/api/user/register

    // http://localhost:8080/api/v1/user/register
    // @GetMapping("/register")
    // public String register(String id) {
    // return id;
    // }

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/v1/test/10
    @GetMapping("/test/{id}")
    public String test(@PathVariable String id) {
        return ResponseEntity.ok(id).toString();
        // return new ResponseEntity<>(status)
    }

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse<UserResponse>> register(@RequestBody UserRequest userRequest) {
        // UserResponse userResponse = new UserResponse();
        SuccessResponse<UserResponse> successResponse = new SuccessResponse<UserResponse>();
        UserResponse userResponse = userService.createUser(userRequest);
        successResponse.setData(userResponse);
        return ResponseEntity.ok(successResponse);

        // return ResponseEntity.ok(new
        // SuccessResponse<UserResponse>(userService.createUser(userRequest)));
    }

}
