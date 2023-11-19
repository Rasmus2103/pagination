package com.example.pagination.api;

import com.example.pagination.entity.Book;
import com.example.pagination.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<Book> getBooks(@RequestParam(required = false) String title,
                               @RequestParam(required = false) String author,
                               Pageable pageable) {
        if (title == null && author == null) {
            return bookService.getAllBooks(pageable);
        } else {
            return bookService.getBooksByTitleAndAuthor(title, author, pageable);
        }
    }
}


