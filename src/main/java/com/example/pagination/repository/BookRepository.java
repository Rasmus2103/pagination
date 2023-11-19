package com.example.pagination.repository;

import com.example.pagination.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) AND " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))")
    Page<Book> findByTitleAndAuthorContainingIgnoreCase(@Param("title") String title,
                                                        @Param("author") String author,
                                                        Pageable pageable);
}
