package com.book.service;

import com.book.model.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(bookRepository::delete);
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll(Sort.by("id"));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(long id, Book book) {
        Book oldBook = findById(id);
        if(oldBook == null)
            return  null;

        buildUpdateBook(book, oldBook);
        return bookRepository.save(book);
    }

    private void buildUpdateBook(Book book, Book oldBook) {
        book.setId(oldBook.getId());
        book.setCreateAt(oldBook.getCreateAt());
        book.setUpdateAt(LocalDateTime.now());
    }
}
