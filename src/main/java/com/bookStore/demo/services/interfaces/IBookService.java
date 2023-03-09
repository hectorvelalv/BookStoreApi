package com.bookStore.demo.services.interfaces;

import com.bookStore.demo.dto.BookDto;
import com.bookStore.demo.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IBookService {

    BookDto addBook(Book book);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    void deleteProductById(Long id);
    List<Book> getAllBooksOfAuthor(Long authorId);
    BookDto updateBook(Long bookId, Book updatedBook);
}
