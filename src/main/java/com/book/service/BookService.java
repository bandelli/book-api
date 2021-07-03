package com.book.service;

import com.book.model.Book;
import com.book.model.dto.BookDTO;
import com.book.repository.BookRepository;
import com.book.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        bookRepository.delete(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Book> findAll() {
        return bookRepository.findAll(Sort.by("id"));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(long id, BookDTO updateBook) {
        Book book = findById(id);
        if (book == null)
            return null;

        buildUpdateBook(updateBook, book);
        return bookRepository.save(book);
    }

    private void buildUpdateBook(BookDTO updateBook, Book oldBook) {
        oldBook.setTitle(updateBook.getTitle());
        oldBook.setAuthor(updateBook.getAuthor());
    }
}
