package win.ccav.tacmal.reponsitory;

import org.springframework.data.repository.CrudRepository;
import win.ccav.tacmal.domain.Order;

public interface TacoReponsitory extends CrudRepository<Order,Long> {
}
