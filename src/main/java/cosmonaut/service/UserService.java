package cosmonaut.service;

import cosmonaut.entity.User;
import cosmonaut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService() {
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        if (userRepository.findById(username).isPresent()) {
            return userRepository.findById(username).get();
        }
        return null;
    }
}
