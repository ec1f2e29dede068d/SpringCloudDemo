package com.c.w.five;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author C
 */
@RestController
public class FeignController {

    @RequestMapping("/stu/sum")
    public void stringData() {
        Student student = new Student(1, "Tom", 89, 100, 90);
        System.out.println(student.toString());
    }

    @RequestMapping(value = "/stu/{sid}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String jsonData(@PathVariable("sid") String sid) {
        Student student = new Student();
        student.setSid(Integer.valueOf(sid));
        student.setsName("Tom");
        student.setChinese(89);
        student.setMath(100);
        student.setEnglish(90);
        System.out.println(new Gson().toJson(student));
        return new Gson().toJson(student);
    }

    @RequestMapping(value = "/stu/createstu", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_XML_VALUE
            , produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String xmlData() {
        return "<result><average>90</average></result>";
    }

}
