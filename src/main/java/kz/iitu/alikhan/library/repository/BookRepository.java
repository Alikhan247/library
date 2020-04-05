package kz.iitu.alikhan.library.repository;


import kz.iitu.alikhan.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE lower(b.authors) LIKE %:search% OR lower(b.title) LIKE %:search% OR lower(b.description) LIKE %:search%")
    List<Book> findAllByTitleIsContainingOrDescriptionContaining(@Param("search") String search);
}
