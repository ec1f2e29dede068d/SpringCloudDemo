package com.c.w.self_health_check_provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    static Boolean canVisitDb = false;

    @RequestMapping(value = "/db/{canVisitDb}", method = RequestMethod.GET)
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDb) {
        HealthController.canVisitDb = canVisitDb;
        System.out.println("==========" + HealthController.canVisitDb);
        return "Now database state is:" + HealthController.canVisitDb;
    }

}
