package com.xiaojian.controller;

import com.xiaojian.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
