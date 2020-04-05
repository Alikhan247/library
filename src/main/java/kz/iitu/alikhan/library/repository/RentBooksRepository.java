package kz.iitu.alikhan.library.repository;


import kz.iitu.alikhan.library.entity.Book;
import kz.iitu.alikhan.library.entity.RentBooks;
import kz.iitu.alikhan.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentBooksRepository extends JpaRepository<RentBooks, Long> {

    public RentBooks findByUserAndBook(User user, Book book);


}
