package kz.iitu.alikhan.library.serivce;


import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.RentBooks;
import kz.iitu.alikhan.library.entity.User;
import kz.iitu.alikhan.library.repository.BookRepository;
import kz.iitu.alikhan.library.repository.RentBooksRepository;
import kz.iitu.alikhan.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class MainService {

    private UserRepository userRepository;
    private BookRepository bookRepository;
    private RentBooksRepository rentBooksRepository;

    public MainService(UserRepository userRepository, BookRepository bookRepository, RentBooksRepository rentBooksRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.rentBooksRepository = rentBooksRepository;
    }

    public Optional<User> findUserById(Long id) {
        System.out.println("Test");
        return userRepository.findById(id);
    }

    public void issueBook(User user, Book book) {
        if (isUserExist(user)) {
            if (book.isAvailable() == true) {
                RentBooks issuedBooks = new RentBooks(user, book);
                rentBooksRepository.save(issuedBooks);

                book.setAvailable(false);
                bookRepository.save(book);
            } else {
                System.out.println("Sorry, but the book is not available at the moment");
            }
        }
    }

    public void returnBook(User user, Book book) {
        if (isUserExist(user)) {
            if (book.isAvailable() == false) {
                RentBooks rentBooks = rentBooksRepository.findByUserAndBook(user, book);
                if (rentBooks != null) {
                    book.setAvailable(true);
                    bookRepository.save(book);
                } else {
                    System.out.println("Error returning book.");
                }
            } else {
                System.out.println("Error returning book");
            }
        }
    }



    public void showAllUsers() {
        for (User user : userRepository.findAll()) {
            System.out.println(user.toString());
        }
    }

    private boolean isUserExist(User user) {
        if (user == null) {
            System.out.println("Error, user does not exist");
            return false;
        } else
            return true;
    }
}
