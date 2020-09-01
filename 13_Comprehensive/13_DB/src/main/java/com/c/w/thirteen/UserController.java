package com.c.w.thirteen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/save")
    public Map<String, Object> save(@RequestBody User user) {
        userService.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "success");
        return map;
    }

    @GetMapping(value = "/stuinfo/{uid}")
    @ResponseBody
    public User selectUser(@PathVariable(value = "uid") String uid) {
        return userService.selectByKey(uid);
    }

}
