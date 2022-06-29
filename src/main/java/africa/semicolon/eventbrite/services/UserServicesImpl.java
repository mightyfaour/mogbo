package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.model.User;
import africa.semicolon.eventbrite.data.repository.UserRepository;
import africa.semicolon.eventbrite.dto.request.LoginRequest;
import africa.semicolon.eventbrite.dto.request.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.LoginResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
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
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("user does not exists");
        }
        if (!request.getPassword().equals(user.getPassword()) ) {
            throw new IllegalArgumentException("password incorrect");
        }
//        if(user.isPresent()){
//            if (request.getPassword().equals(user.get().getPassWord())){
               LoginResponse response = new LoginResponse();
                response.setMessage("LogIn SUCCESSFUL!");
               // return response;
//            }
//        }
        //  throw  new NullPointerException("not found");
        return response;
    }
}
