package com.example.bai4;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BorrowingRepository {

    private final List<Borrowing> borrowings = List.of(
            new Borrowing(1L, 101L, 201L),
            new Borrowing(2L, 102L, 202L),
            new Borrowing(3L, 103L, 203L)
    );

    public Borrowing findById(Long id) {
        return borrowings.stream()
                .filter(b -> b.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
