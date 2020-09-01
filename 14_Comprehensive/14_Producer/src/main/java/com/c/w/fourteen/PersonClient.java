package com.c.w.fourteen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "dbService", fallback = PersonClient.PersonClientFallback.class)
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/stuinfo/{sid}")
    User getPerson(@PathVariable("sid") String sid);

    @RequestMapping(method = RequestMethod.GET, value = "/allstuinfo/{cid}")
    List<User> getAllStuByCid(@PathVariable("cid") Integer cid);

    @Component
    class PersonClientFallback implements PersonClient {

        @Override
        public User getPerson(String uid) {
            return new User("zero", "none", "none", 0, 0, 0);
        }

        @Override
        public List<User> getAllStuByCid(Integer cid) {
            List<User> userList = new ArrayList<>();
            userList.add(new User("zero", "none", "none", 0, 0, 0));
            return userList;
        }

    }

}
