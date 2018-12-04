package com.morrisje.spring5webapp.controllers;

import com.morrisje.spring5webapp.repositories.BookRepsoitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jmorris on 12/4/18
 */
@Controller
public class BookController {

    private BookRepsoitory bookRepsoitory;

    public BookController(BookRepsoitory bookRepsoitory) {
        this.bookRepsoitory = bookRepsoitory;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)  {

        model.addAttribute("books", bookRepsoitory.findAll());
        return "books";
    }
}
