package beadando_4.Dao.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column()
    private String username;
    @Column()
    private int password_hashed;
    @Column()
    private String fullname;
}
