package com.ztrzaska.mongodb.config;

import com.ztrzaska.mongodb.model.AuthorEntity;
import com.ztrzaska.mongodb.model.BookEntity;
import com.ztrzaska.mongodb.model.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoDatabaseInitializer {

    private final MongoTemplate mongoTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        CommentEntity comment1 = createComment("Everyone Should Read At Least Once");
        CommentEntity comment2 = createComment("My new comment");

        createBook(comment1, "J.K.", "Rowling", "Harry Potter");
        createBook(comment2, "Maya", "Angelou", "I Know Why The Caged Bird Sings");
    }

    private CommentEntity createComment(String text) {
        CommentEntity comment = CommentEntity.builder()
                .text(text)
                .build();
        return mongoTemplate.save(comment);
    }

    private void createBook(CommentEntity comment, String authorFirstName, String authorLastName, String title) {
        AuthorEntity author = createAuthor(authorFirstName, authorLastName);

        BookEntity book = BookEntity.builder()
                .author(author)
                .title(title)
                .comments(List.of(comment))
                .build();
        mongoTemplate.save(book);
    }

    private AuthorEntity createAuthor(String authorFirstName, String authorLastName) {
        AuthorEntity author = AuthorEntity.builder()
                .firstName(authorFirstName)
                .lastName(authorLastName)
                .build();
        return mongoTemplate.save(author);
    }
}
