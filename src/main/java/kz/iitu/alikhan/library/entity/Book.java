package kz.iitu.alikhan.library.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "genere", "rentBooks"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;


    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genere_id")
    private Genre genere;

    @OneToMany(mappedBy = "book")
    private List<RentBooks> rentBooks;

    private boolean isAvailable = true;

    public Book(String title, String description, Genre genre, Set<Author> author) {
        this.title = title;
        this.description = description;
        this.genere = genre;
        this.authors = author;
    }

    public Book() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenere() {
        return genere;
    }

    public void setGenere(Genre genere) {
        this.genere = genere;
    }

    public List<RentBooks> getRentBooks() {
        return rentBooks;
    }

    public void setRentBooks(List<RentBooks> rentBooks) {
        this.rentBooks = rentBooks;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
