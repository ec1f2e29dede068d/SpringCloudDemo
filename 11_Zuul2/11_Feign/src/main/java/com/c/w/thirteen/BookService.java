package com.c.w.thirteen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuul-book-service")
public interface BookService {

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookId}")
    Book getBook(@PathVariable("bookId") Integer bookId);

}
