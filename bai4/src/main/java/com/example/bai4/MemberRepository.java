package com.example.bai4;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    private final List<Member> members = List.of(
            new Member(201L, "Nguyen Van A"),
            new Member(202L, "Tran Van B"),
            new Member(203L, "Le Van C")
    );

    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
