package kz.iitu.alikhan.library.serivce;

import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.RentBooks;
import kz.iitu.alikhan.library.repository.BookRepository;
import kz.iitu.alikhan.library.repository.RentBooksRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;
    private final RentBooksRepository rentBooks;

    public BookService(BookRepository bookRepository, RentBooksRepository rentBooksRepository) {
        this.rentBooks = rentBooksRepository;
        this.bookRepository = bookRepository;
    }

    public void showAllBooks(){
        for (Book book: bookRepository.findAll()){
            System.out.println(book.toString());
        }
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void findBook(String search){
        for (Book book: bookRepository.findAllByTitleIsContainingOrDescriptionContaining(search)){
            System.out.println(book.toString());
        }
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }

}
