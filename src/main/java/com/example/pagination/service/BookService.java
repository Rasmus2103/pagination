package com.example.pagination.service;

import com.example.pagination.entity.Book;
import com.example.pagination.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> getBooksByTitleAndAuthor(String title, String author, Pageable pageable) {
        return bookRepository.findByTitleAndAuthorContainingIgnoreCase(title, author, pageable);
    }

}
