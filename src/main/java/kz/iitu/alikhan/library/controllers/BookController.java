package kz.iitu.alikhan.library.controllers;

import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.Genre;
import kz.iitu.alikhan.library.serivce.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

@Component
public class BookController {

    private Scanner in = new Scanner(System.in);


    private final BookService bookService;
    private final AuthorController authorController;

    public BookController(BookService bookService, AuthorController authorController) {
        this.bookService = bookService;
        this.authorController = authorController;
    }

    public void showMenu(){
        System.out.println("1. Show all books");
        System.out.println("3. Find book");
    }

    public void choice(int choice){
        switch (choice){
            case 1:
                showAllBooks();
                break;
            case 2:
//                addNewBook();
                break;
            case 3:
                findBook();
                break;
            default:
                System.out.println("There is no such option");
                break;
        }
    }

    public void showAllBooks(){
        bookService.showAllBooks();
    }
    public Book findBookById(){
        System.out.println("Enter book ID: ");
        Long id = in.nextLong();
        return bookService.findBookById(id).orElse(null);
    }

    public void findBook(){
        System.out.println("Find book by author name, title or description");
        String search = in.nextLine();
        search = search.toLowerCase();
        bookService.findBook(search);
    }

}
