package africa.semicolon.eventbrite.util;

import africa.semicolon.eventbrite.data.model.User;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        return user;

    }
    public static void map(RegisterUserRequest request, User user) {

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
    }
    public static  void map(User savedUser, RegisterUserResponse response) {
        response.setEmail(savedUser.getEmail());
        response.setDataCreated(DateTimeFormatter.ofPattern("EEEE, dd/mm/yyyy, hh:mm, a").format(savedUser.getDateTime()));
    }
}
