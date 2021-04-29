package beadando_4.Dao;

import beadando_4.Dao.Entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<RegisterEntity, Long> {
}
