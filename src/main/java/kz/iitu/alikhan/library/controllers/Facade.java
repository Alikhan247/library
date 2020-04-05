package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Facade {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

    AuthorController authorController = context.getBean("authorController", AuthorController.class);
    BookController bookController = context.getBean("bookController", BookController.class);
    MainController mainController = context.getBean("mainController", MainController.class);

    Scanner sc = new Scanner(System.in);

    public void showMenu(){
        System.out.println("1. Authors options");
        System.out.println("2. Books options");
        System.out.println("3. issue options");

        System.out.println("Enter your option: ");

        choice(sc.nextInt());
    }

    private void choice(int choice){
        switch (choice){
            case 1:
                authorController.showMenu();
                System.out.println("Enter number");
                authorController.choice(sc.nextInt());
                break;
            case 2:
                bookController.showMenu();
                System.out.println("Enter number");
                bookController.choice(sc.nextInt());
                break;
            case 3:
                mainController.showMenu();
                System.out.println("Enter number");
                mainController.choice(sc.nextInt());
                break;
            default:
                System.out.println("Error, no option");
                break;
        }
    }
}
