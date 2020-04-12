package kz.iitu.alikhan.library.serivce;

import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.repository.BookRepository;
import kz.iitu.alikhan.library.repository.RentBooksRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;
    private final RentBooksRepository rentBooks;

    public BookService(BookRepository bookRepository, RentBooksRepository rentBooksRepository) {
        this.rentBooks = rentBooksRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findBook(String search) {
        return bookRepository.findAllByTitleIsContainingOrDescriptionContaining(search);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

}
