package beadando_4.Dao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterDaoImpl implements RegisterDao {
    private final RegisterRepository registerRepository;

    @Override
    public Collection<RegisterData> readAll() {
        return StreamSupport.stream(registerRepository.findAll().spliterator(), false).map(entity -> RegisterData.builder()
        .username(entity.getUsername()).password(entity.getPassword_hashed()).fullname(entity.getFullname()).build()).collect(Collectors.toList());
    }

    @Override
    public void save(RegisterData registerData) {
        beadando_4.Dao.Entity.RegisterEntity entity = new beadando_4.Dao.Entity.RegisterEntity();
        entity.setUsername(registerData.getUsername());
        entity.setPassword_hashed(registerData.getPassword());
        entity.setFullname(registerData.getFullname());
    }
}
