package com.bookStore.demo.controllers;

import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.services.implementations.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BookDto> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(value = "id") final Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("deleteBook/{id}")
    public void deleteBookById(@PathVariable(value = "id") final Long id){
        bookService.deleteProductById(id);
    }

    @PutMapping("editBook/{id}")
    public ResponseEntity<BookDto> editBook(@PathVariable(value = "id") final Long id, @RequestBody final Book editedBook){
        return new ResponseEntity<>(bookService.updateBook(id, editedBook),HttpStatus.OK);
    }
}
