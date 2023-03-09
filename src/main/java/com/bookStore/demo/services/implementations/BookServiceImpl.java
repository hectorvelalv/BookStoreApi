package com.bookStore.demo.services.implementations;

import com.bookStore.demo.dto.BookDto;
import com.bookStore.demo.entities.Book;
import com.bookStore.demo.exceptions.BookIdNotFoundException;
import com.bookStore.demo.mappers.BookMapper;
import com.bookStore.demo.repositories.IBookRepository;
import com.bookStore.demo.services.interfaces.IBookService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final IBookRepository bookRepository;

    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto addBook(Book book) {
//        return bookToBookDtoConverter.convert(bookRepository.save(book));
        return BookMapper.INSTANCE.bookToBookDto(bookRepository.save(book));

    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(BookMapper.INSTANCE::bookToBookDto).toList();
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
    public List<Book> getAllBooksOfAuthor(Long authorId) {
        return null;
    }

    @Override
    public BookDto updateBook(Long bookId, Book updatedBook) {
        return  bookRepository.findById(bookId).map( oldBook -> {
                    updatedBook.setId(bookId);
                    return bookRepository.save(updatedBook);
                }).map(BookMapper.INSTANCE::bookToBookDto)
                    .orElseThrow(BookIdNotFoundException::new);
    }
}
