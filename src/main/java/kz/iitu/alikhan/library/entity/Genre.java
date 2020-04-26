package kz.iitu.alikhan.library.entity;

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
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "genere", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();;


    public Genre(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Genre(){

    }
}
