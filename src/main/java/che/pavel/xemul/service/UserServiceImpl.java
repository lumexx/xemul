package che.pavel.xemul.service;

import che.pavel.xemul.model.User;
import che.pavel.xemul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Long id) { return userRepository.getOne(id); }

    @Override
    public void save(User user) { userRepository.save(user); }

    @Override
    public void delete(User user) { userRepository.delete(user); }

    @Override
    public Page<User> findAll(Pageable pageable) { return userRepository.findAll(pageable); }

}
