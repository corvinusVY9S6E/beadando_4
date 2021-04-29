package beadando_4.Dao;

import java.util.Collection;

public interface RegisterDao {
    Collection<RegisterData> readAll();
    void save (RegisterData registerData);
}
