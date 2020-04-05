package kz.iitu.alikhan.library;

import kz.iitu.alikhan.library.controllers.AuthorController;
import kz.iitu.alikhan.library.controllers.BookController;
import kz.iitu.alikhan.library.controllers.Facade;
import kz.iitu.alikhan.library.controllers.MainController;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.serivce.MainService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.showMenu();
    }
}
