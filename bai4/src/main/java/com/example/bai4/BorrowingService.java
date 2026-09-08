package com.example.bai4;

import org.springframework.stereotype.Service;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowingService(
            BorrowingRepository borrowingRepository,
            BookRepository bookRepository,
            MemberRepository memberRepository
    ) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public String getBorrowingDetail(Long borrowingId) {

        Borrowing borrowing =
                borrowingRepository.findById(borrowingId);

        if (borrowing == null) {
            return "Borrowing not found";
        }

        Book book =
                bookRepository.findById(borrowing.bookId());

        Member member =
                memberRepository.findById(borrowing.memberId());

        if (book == null) {
            return "Book not found";
        }

        if (member == null) {
            return "Member not found";
        }

        return "Book: " + book.title()
                + " - Member: " + member.name();
    }
}
