package beadando_4.Service;

import beadando_4.RegistrationExistsException;
import beadando_4.RegistrationNotExistException;

import java.util.Collection;

public interface RegisterService {
    void Register(RegisterData registerData) throws RegistrationExistsException;
    void Login(LoginData loginData) throws RegistrationNotExistException;
    Collection<RegisterData> getAll();
    Collection<LoginData> getUsernameAndPassword();
}
