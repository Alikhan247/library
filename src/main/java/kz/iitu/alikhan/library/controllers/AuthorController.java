package kz.iitu.alikhan.library.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.serivce.AuthorService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("")
    public List<Author> showAllAuthors(){
        return authorService.showAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id){
        return authorService.getAuthorById(id).get();
    }

    @GetMapping("/find/")
    public List<Author> getAuthorByName(@RequestParam("name") String name){
        return authorService.getAuthorByName(name);
    }

}