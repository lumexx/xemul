package che.pavel.xemul.service;

import che.pavel.xemul.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getById(Long id);

    void save(User user);

    void delete(User user);

    Page<User> findAll(Pageable pageable);
}
