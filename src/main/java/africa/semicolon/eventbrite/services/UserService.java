package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.dto.requests.CreatePartyRequest;
import africa.semicolon.eventbrite.dto.requests.LoginRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.CreatePartyResponse;
import africa.semicolon.eventbrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.exception.UserDoesNotExistException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginUserResponse login (LoginRequest request);
    CreatePartyResponse addParty(CreatePartyRequest request) throws UserDoesNotExistException;

    RegisterUserResponse loginUser(RegisterUserRequest loginUserRequest);
}
