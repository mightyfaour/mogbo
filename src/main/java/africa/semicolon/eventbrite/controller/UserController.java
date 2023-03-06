package africa.semicolon.eventbrite.controller;

import africa.semicolon.eventbrite.dto.requests.CreatePartyRequest;
import africa.semicolon.eventbrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventbrite.dto.responses.ApiResponse;
import africa.semicolon.eventbrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventbrite.exception.DuplicatedEmailException;
import africa.semicolon.eventbrite.services.PartyService;
import africa.semicolon.eventbrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private PartyService partyService;

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
        try {
            var serviceResponse = userService.registerUser(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
        } catch (DuplicatedEmailException ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login/user")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest loginUserRequest){
        return userService.loginUser(loginUserRequest);
    }

    @PostMapping("/party")
    public ResponseEntity<?>createParty(@RequestBody CreatePartyRequest createPartyRequest){
        try{
            var serviceResponse = partyService.saveparty(createPartyRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (DuplicatedEmailException ex){
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
//..............................................................................................................
//package africa.semicolon.mogbo.controller;

//
//        import africa.semicolon.eventbrite.dto.request.RegisterUserRequest;
//        import africa.semicolon.eventbrite.services.UserService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/user")
//    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request){
//        try {
//            var serviceResponse  = userService.registerUser(request);
//            ApiResponse response = new ApiResponse(true, serviceResponse);
//            return  new ResponseEntity<>( userService.registerUser(request),HttpStatus.CREATED);
//        }catch (DuplicateException ex){
//            ApiResponse response = new ApiResponse(false, ex.getMessage());
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//
//    }
//
//    @PostMapping("/login/user")
//    public LoginUserResponse login(@RequestBody LoginUserRequest request){
//        return userService.login(request);
//    }
//
//}