package com.ztrzaska.mongodb.repository;

import com.ztrzaska.mongodb.model.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<BookEntity, String> {

    List<BookEntity> findByTitle(String title);
}
