package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.request.LoginRequest;
import africa.semicolon.eventbrite.dto.request.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginResponse login (LoginRequest request);

}
