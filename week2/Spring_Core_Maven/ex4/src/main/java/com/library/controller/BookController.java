package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @RequestMapping("/books")
    @ResponseBody
    public String getBooks() {
        return "List of books retrieved from BookController";
    }
}
