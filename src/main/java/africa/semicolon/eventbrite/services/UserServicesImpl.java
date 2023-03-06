package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.model.User;
import africa.semicolon.eventbrite.data.repositories.UserRepository;
import africa.semicolon.eventbrite.dto.requests.CreatePartyRequest;
import africa.semicolon.eventbrite.dto.requests.LoginRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.CreatePartyResponse;
import africa.semicolon.eventbrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.exception.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
//        User user = new User();

//        map user

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setDataCreated(DateTimeFormatter.ofPattern("EEEE, dd/mm/yyyy, hh:mm: a").format(savedUser.getDateTime()));
        return response;

    }

    @Override
    public LoginUserResponse login(LoginRequest request) {

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (!user.isPresent()) {
            throw new IllegalArgumentException("user does not exists");
        }
        if (!request.getPassword().equals(user.getPassword()) ) {
            throw new IllegalArgumentException("password incorrect");
        }
//        if(user.isPresent()){
//            if (request.getPassword().equals(user.get().getPassWord())){
               LoginUserResponse response = new LoginUserResponse();
                response.setMessage("LogIn SUCCESSFUL!");
               // return response;
//            }
//        }
        //  throw  new NullPointerException("not found");
        return response;
    }

    @Override
    public CreatePartyResponse addParty(CreatePartyRequest request) throws UserDoesNotExistException {
        return null;
    }

    @Override
    public RegisterUserResponse loginUser(RegisterUserRequest loginUserRequest) {
        return null;
    }


}
