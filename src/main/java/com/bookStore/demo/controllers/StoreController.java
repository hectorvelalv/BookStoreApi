package com.bookStore.demo.controllers;

import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.services.implementations.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStoreApi")
public class StoreController {

    private final BookServiceImpl bookService;

    public StoreController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public BookDto addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/getBook/{id}")
    public BookDto getBookById(@PathVariable(value = "id") final Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("deleteBook/{id}")
    public void deleteBookById(@PathVariable(value = "id") final Long id){
        bookService.deleteProductById(id);
    }

    @PutMapping("editBook/{id}")
    public BookDto editBook(@PathVariable(value = "id") final Long id, @RequestBody final Book editedBook){
        return bookService.updateBook(id, editedBook);
    }
}
