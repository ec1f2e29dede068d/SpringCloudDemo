package com.c.w.thirteen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public User selectByKey(String uid) {
        Optional<User> optionalUser = userRepository.findById(uid);
        return optionalUser.orElse(null);
    }

}
