package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.Main;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.User;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class MainController {

    private Scanner sc = new Scanner(System.in);
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
                showAllUsers();
                break;
            case 3:
                returnTheBook();
                break;
            default:
                System.out.println("Option does not exist");
                break;
        }
    }

    public void showAllUsers(){
        mainService.showAllUsers();
    }

    public User findUserById(){
        System.out.println("Issue book to...");
        System.out.println("Enter user ID: ");
        Long id = sc.nextLong();

        return mainService.findUserById(id).orElse(null);
    }

    public void issueBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        mainService.issueBook(user, book);
    }

    public void returnTheBook(){
        User user = findUserById();
        Book book = bookController.findBookById();
        mainService.returnBook(user, book);
    }
}
