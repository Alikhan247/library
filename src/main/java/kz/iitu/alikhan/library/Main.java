package kz.iitu.alikhan.library;

import kz.iitu.alikhan.library.controllers.AuthorController;
import kz.iitu.alikhan.library.controllers.BookController;
import kz.iitu.alikhan.library.controllers.MainController;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AuthorController authorController = context.getBean("authorController", AuthorController.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        MainController mainController = context.getBean("mainController", MainController.class);

        Scanner sc = new Scanner(System.in);

        int choice;
//        authorController.showMenu();
//        choice = sc.nextInt();
//        authorController.choice(choice);

        bookController.showMenu();

        bookController.showAllBooks();

        mainController.showMenu();
        mainController.issueBook();
    }
}
