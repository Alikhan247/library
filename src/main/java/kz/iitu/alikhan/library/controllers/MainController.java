package kz.iitu.alikhan.library.controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.User;
import kz.iitu.alikhan.library.serivce.BookService;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation(value = "Get all users", response = List.class)
    @GetMapping("")
    public List<User> getAllUsers() {
        return mainService.showAllUsers();
    }

    @ApiOperation(value = "Get user with given id", response = User.class)
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return mainService.findUserById(id).orElse(null);
    }

    @ApiOperation(value = "Register a new user", response = User.class)
    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return mainService.saveUser(user);
    }

    @ApiOperation(value = "Issue a book to the user")
    @PostMapping("/issue/")
    public void issueBook(@RequestParam("user_id") Long userId,@RequestParam("book_id") Long bookId){
        User user = mainService.findUserById(userId).get();
        Book book = bookService.findBookById(bookId).get();
        mainService.issueBook(user, book);
    }

    @ApiOperation(value = "Return back book that was given to the user")
    @PostMapping("/return/")
    public void returnTheBook(@RequestParam("user_id")Long userId,@RequestParam("book_id") Long bookId){
        User user = mainService.findUserById(userId).get();
        Book book = bookService.findBookById(bookId).get();
        mainService.returnBook(user, book);
    }
}
