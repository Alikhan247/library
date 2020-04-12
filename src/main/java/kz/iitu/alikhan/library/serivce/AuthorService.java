package kz.iitu.alikhan.library.serivce;

import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> showAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getAuthorByName(String name){
        return authorRepository.findAuthorByNameContains(name);
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

}
