package africa.semicolon.eventbrite.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class LoginRequest {

        private String email;
        private String password;

}
