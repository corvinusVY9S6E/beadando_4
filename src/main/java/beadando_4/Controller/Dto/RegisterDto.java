package beadando_4.Controller.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class RegisterDto {

    @NotNull(message = "Username cannot be empty")
    @Size(min = 6,message = "Username must be at least 6 characters long")
    private String username;

    @NotNull (message = "Password cannot be empty")
    @Size (min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Name cannot be empty")
    private String fullname;
}
