package kz.iitu.alikhan.library.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
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


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genere_id")
    private Genre genere;

    @ToString.Exclude
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
}
