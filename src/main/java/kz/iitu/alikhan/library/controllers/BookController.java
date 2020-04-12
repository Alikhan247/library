package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.Genre;
import kz.iitu.alikhan.library.serivce.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorController authorController;

    public BookController(BookService bookService, AuthorController authorController) {
        this.bookService = bookService;
        this.authorController = authorController;
    }

    @GetMapping("")
    public List<Book> showAllBooks() {
        return bookService.showAllBooks();
    }


    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookService.findBookById(id).orElse(null);
    }

    @GetMapping("/find/")
    public List<Book> findBook(@RequestParam("title") String title) {
        return bookService.findBook(title);
    }

}
