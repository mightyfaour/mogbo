package africa.semicolon.eventbrite.controller;

import africa.semicolon.eventbrite.dto.request.LoginRequest;
import africa.semicolon.eventbrite.dto.request.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request){
        return userService.registerUser(request);
    }

    @PostMapping("/user/login")
    public LoginResponse LogIn(@RequestBody LoginRequest request){
        return userService.login(request);
    }
}
