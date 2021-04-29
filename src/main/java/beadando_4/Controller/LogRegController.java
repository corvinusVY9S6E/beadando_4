package beadando_4.Controller;
import beadando_4.Controller.Dto.LoginDto;
import beadando_4.Controller.Dto.RegisterDto;
import beadando_4.RegistrationExistsException;
import beadando_4.RegistrationNotExistException;
import beadando_4.Service.LoginData;
import beadando_4.Service.RegisterData;
import beadando_4.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LogRegController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public void Register(@Valid @RequestBody RegisterDto registerDto){
        try {
            registerService.Register(RegisterData.builder()
                    .username(registerDto.getUsername())
                    .password(registerDto.getPassword().hashCode())
                    .fullname(registerDto.getFullname())
                    .build());
        }
        catch (RegistrationExistsException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is already taken.");
        }
    }

    @PostMapping("/login")
    public void Login(@RequestBody LoginDto loginDto){
        try {
            registerService.Login(LoginData.builder()
                    .username(loginDto.getUsername())
                    .password(loginDto.getPassword().hashCode())
                    .build());
        }
        catch (RegistrationNotExistException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Incorrect username or password.");
        }
    }
}
