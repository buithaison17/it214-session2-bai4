package com.example.bai4;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = List.of(
            new Book(101L, "Clean Code"),
            new Book(102L, "Effective Java"),
            new Book(103L, "Java Concurrency in Practice")
    );

    public Book findById(Long id) {
        return books.stream()
                .filter(b -> b.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
