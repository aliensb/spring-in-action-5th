package win.ccav.tacmal.reponsitory;

import org.springframework.data.repository.CrudRepository;
import win.ccav.tacmal.domain.User;

public interface UserReponsitory extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
