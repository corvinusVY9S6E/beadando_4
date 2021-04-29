package beadando_4.Service;

import beadando_4.Dao.RegisterDao;
import beadando_4.RegistrationExistsException;
import beadando_4.RegistrationNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterDao registerDao;

    @Override
    public void Register(RegisterData registerData) throws RegistrationExistsException {
        Collection<RegisterData> all = getAll();
        for (RegisterData data: all){
            if (data.getUsername().equals(registerData.getUsername())){
                throw new RegistrationExistsException();
            }
        }
        registerDao.save(beadando_4.Dao.RegisterData.builder()
                .username(registerData.getUsername())
                .password(registerData.getPassword())
                .fullname(registerData.getFullname())
                .build());

    }

    @Override
    public void Login(LoginData loginData) throws RegistrationNotExistException {
        Collection<LoginData> all = getUsernameAndPassword();
        if (!all.contains(loginData)){
            throw new RegistrationNotExistException();
        }
    }

    @Override
    public Collection<RegisterData> getAll() {
        return registerDao.readAll().stream().map(entity -> RegisterData.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .fullname(entity.getFullname())
                .build())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<LoginData> getUsernameAndPassword() {
        return registerDao.readAll().stream().map(entity -> LoginData.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build())
                .collect(Collectors.toList());
    }
}
