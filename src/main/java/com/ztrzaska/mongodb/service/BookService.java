package com.ztrzaska.mongodb.service;

import com.ztrzaska.mongodb.model.BookEntity;
import com.ztrzaska.mongodb.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public String save(BookEntity book) {
        return bookRepository.save(book).getId().toString();
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public List<BookEntity> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
