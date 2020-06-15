package com.c.w.thirteen;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SaleController {

    @Resource
    private BookService bookService;

    @RequestMapping(value = "/sale-book/{bookId}", method = RequestMethod.GET)
    public String saleBook(@PathVariable Integer bookId) {
        Book book = bookService.getBook(bookId);
        System.out.println("销售模块处理销售，要销售图书id：" + book.getId() + "，书名：" + book.getName());
        return "SUCCESS";
    }

    @RequestMapping(value = "/errorTest", method = RequestMethod.GET)
    public String errorTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "errorTest";
    }

}
