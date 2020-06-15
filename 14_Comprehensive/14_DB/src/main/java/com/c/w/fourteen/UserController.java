package com.c.w.fourteen;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping(value = "/stuinfo/{sid}")
    @ResponseBody
    public User selectUser(@PathVariable(value = "sid") String sid) {
        return userService.selectByKey(sid);
    }

    @GetMapping(value = "/allstuinfo/{cid}")
    @ResponseBody
    public List<User> getAllStuByCid(@PathVariable(value = "cid") Integer cid) {
        return userService.getAllStuByCid(cid);
    }

}
