package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.User;
import kz.iitu.alikhan.library.serivce.BookService;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/users")
public class MainController {
    private final MainService mainService;

    private final BookService bookService;


    public MainController(MainService mainService, BookService bookService) {
        this.mainService = mainService;
        this.bookService = bookService;
    }


    @GetMapping("")
    public List<User> showAllUsers() {
        return mainService.showAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return mainService.findUserById(id).orElse(null);
    }

    @PostMapping("/issue/")
    public void issueBook(@RequestParam("user_id") Long userId,@RequestParam("book_id") Long bookId){
        User user = mainService.findUserById(userId).get();
        Book book = bookService.findBookById(bookId).get();
        mainService.issueBook(user, book);
    }

    @PostMapping("/return/")
    public void returnTheBook(@RequestParam("user_id")Long userId,@RequestParam("book_id") Long bookId){
        User user = mainService.findUserById(userId).get();
        Book book = bookService.findBookById(bookId).get();
        mainService.returnBook(user, book);
    }
}
