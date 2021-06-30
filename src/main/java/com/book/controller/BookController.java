package com.book.controller;

import com.book.model.Book;
import com.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }

    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<Object> save(@RequestBody Book book) {
        final Book  b = bookService.save(book);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("{id}")
                .build(b.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody @Valid Book book) {
        return bookService.update(id, book);
    }
}
