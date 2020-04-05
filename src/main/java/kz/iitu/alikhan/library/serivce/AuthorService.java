package kz.iitu.alikhan.library.serivce;

import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void showAllAuthors(){
        for(Author author: authorRepository.findAll()){
            System.out.println("Author's ID: " + author.getId() + " " + "Author's name: " + author.getName());
        }
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

}
