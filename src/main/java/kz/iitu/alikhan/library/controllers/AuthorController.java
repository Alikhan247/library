package kz.iitu.alikhan.library.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.library.entity.Author;
import kz.iitu.alikhan.library.serivce.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @ApiOperation(value = "Returns all authors in the database", response = List.class)
    @GetMapping("")
    public List<Author> showAllAuthors(){
        return authorService.showAllAuthors();
    }

    @ApiOperation(value = "Get specific author", response = Author.class)
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id){
        return authorService.getAuthorById(id).get();
    }

    @ApiOperation(value = "Get all authors with given name (search)", response = List.class)
    @GetMapping("/find/")
    public List<Author> getAuthorByName(@RequestParam("name") String name){
        return authorService.getAuthorByName(name);
    }

}