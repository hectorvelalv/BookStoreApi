package com.bookStore.demo.services.implementations;

import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.exceptions.BookIdNotFoundException;
import com.bookStore.demo.mappers.BookMapper;
import com.bookStore.demo.models.entities.Page;
import com.bookStore.demo.repositories.IAuthorRepository;
import com.bookStore.demo.repositories.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    private final IBookRepository bookRepository;

    @Override
    public BookDto addBook(Book book) {
        return BookMapper.INSTANCE.bookToBookDto(bookRepository.save(book));
    }
    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();
        bookRepository.findAll().forEach(book -> bookDtoList.add(BookMapper.INSTANCE.bookToBookDto(book)));
        return  bookDtoList;
    }
    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper.INSTANCE::bookToBookDto)
                .orElseThrow(BookIdNotFoundException::new);
    }
    @Override
    public void deleteProductById(Long bookId) {
        if(bookRepository.findById(bookId).isEmpty()) throw new BookIdNotFoundException();
        bookRepository.findById(bookId)
                .ifPresent(
                        book -> bookRepository.deleteById(bookId)
                );
    }
    @Override
    public List<BookDto> getAllBooksOfAuthor(Author author) {
        return bookRepository.findByAuthors(author).stream().map(BookMapper.INSTANCE::bookToBookDto).toList();
    //    return null;
    }

    @Override
    public BookDto updateBook(Long bookId, Book updatedBook) {
        return  bookRepository.findById(bookId).map( oldBook -> {
                    updatedBook.setId(bookId);
                    return bookRepository.save(updatedBook);
                }).map(BookMapper.INSTANCE::bookToBookDto)
                    .orElseThrow(BookIdNotFoundException::new);
    }

    @Override
    public List<Book> findAllAuthorsBooksByPage(Long id) {
        return bookRepository.findAllAuthorsBooksByPage(id);
    }
}
