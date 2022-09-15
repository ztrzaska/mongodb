package com.ztrzaska.mongodb.controller;

import com.ztrzaska.mongodb.model.BookEntity;
import com.ztrzaska.mongodb.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@ApiOperation("Books API")
public class BookController {

    private final BookService bookService;

    @ApiOperation(value = "Save a book", notes = "Returns a id of saved book")
    @PostMapping("/")
    public String save(@ApiParam(name =  "book", value = "book definition") BookEntity book) {
        return bookService.save(book);
    }

    @ApiOperation(value = "Finds all books", notes = "Returns all books")
    @GetMapping("/")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find-by-title")
    public List<BookEntity> findByTitle(@ApiParam(name =  "title", value = "Title of the book")
                                            @RequestParam("title") String title) {
        return bookService.findByTitle(title);
    }

}
