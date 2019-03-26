package win.ccav.tacmal.domain.vo;


import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import win.ccav.tacmal.domain.User;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {
    @NotBlank(message="username is required")
    private String username;
    @NotBlank(message="password is required")
    private String password;
    @NotBlank(message="fullname is required")
    private String fullname;
    @NotBlank(message="street is required")
    private String street;
    @NotBlank(message="city is required")
    private String city;
    @NotBlank(message="state is required")
    private String state;
    @NotBlank(message="zip is required")
    private String zip;
    @NotBlank(message="phone is required")
    private String phone;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}