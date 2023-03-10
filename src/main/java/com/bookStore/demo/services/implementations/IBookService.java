package com.bookStore.demo.services.implementations;

import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IBookService {

    BookDto addBook(Book book);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    void deleteProductById(Long id);
    List<BookDto> getAllBooksOfAuthor(String author);
    BookDto updateBook(Long bookId, Book updatedBook);
}
