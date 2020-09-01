package com.c.w.fourteen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private StuClassRepository stuClassRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User selectByKey(String uid) {
        Optional<User> optionalUser = userRepository.findById(uid);
        return optionalUser.orElse(null);
    }

    public List<User> getAllStuByCid(Integer cid) {
        Optional<StuClass> stuClassOptional = stuClassRepository.findById(cid);
        return stuClassOptional.map(StuClass::getUsers).orElse(null);
    }

}
