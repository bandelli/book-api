package com.book.controller;

import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        bookService.delete(id);
    }

    @GetMapping("/list")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find/{id}")
    public Book findById(@PathVariable("id") long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable("id") long id, @RequestBody @Valid Book book) {
        return bookService.update(id, book);
    }
}
