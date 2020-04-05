package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.Main;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.User;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class MainController {

    private Scanner in = new Scanner(System.in);
    //Services
    private final MainService mainService;

    //Controllers
    private final BookController bookController;


    public MainController(MainService mainService, BookController bookController) {
        this.mainService = mainService;
        this.bookController = bookController;
    }

    public void showMenu(){
        System.out.println("1. Issue book");
        System.out.println("2. Show all users");
        System.out.println("3. Return book");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                issueBook();
                break;
            case 2:
                shooAllUsers();
                break;
            case 3:
                returnBook();
                break;
            default:
                System.out.println("There is no such option");
                break;
        }
    }

    public void shooAllUsers(){
        mainService.showAllUsers();
    }

    public User findUserById(){
        System.out.println("Enter user ID: ");
        Long id = in.nextLong();
        return mainService.findUserById(id).orElse(null);
    }

    public void issueBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        mainService.issueBook(user, book);
    }

    public void returnBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        mainService.returnBook(user, book);
    }
}
