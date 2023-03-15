package com.bookStore.demo.controllers;

import com.bookStore.demo.models.dtos.AuthorDto;
import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.dtos.PageDto;
import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.models.entities.Page;
import com.bookStore.demo.services.implementations.AuthorServiceImpl;
import com.bookStore.demo.services.implementations.BookServiceImpl;
import com.bookStore.demo.services.implementations.PageServiceImpl;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookStoreApi")
public class StoreController {
    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;
    private final PageServiceImpl pageService;

    public StoreController(BookServiceImpl bookService, AuthorServiceImpl authorService, PageServiceImpl pageService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.pageService = pageService;
    }


    //books
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
    public void deleteBookById(@PathVariable(value = "id") final Long id) {
        bookService.deleteProductById(id);
    }

    @PutMapping("editBook/{id}")
    public BookDto editBook(@PathVariable(value = "id") final Long id, @RequestBody final Book editedBook) {
        return bookService.updateBook(id, editedBook);
    }


    //authors
    @PostMapping("/createAuthor")
    public AuthorDto createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/getAuthor/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/editAuthor/{id}")
    public AuthorDto editAuthor(@PathVariable(value = "id") Long id, @RequestBody Author author) {
        return authorService.editAuthor(id, author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable(value = "id") Long id) {
        authorService.deleteAuthorById(id);
    }


    //pages
    @PostMapping("/createPage")
    public PageDto createPage(@RequestBody Page page){
        return pageService.addPage(page);
    }

    @GetMapping("/getPage/{id}")
    public PageDto getPageById(@PathVariable(value = "id")Long id){
        return pageService.getPageById(id);
    }

    @DeleteMapping("/deletePage/{id}")
    public void deletePageById(@PathVariable(value = "id")Long id){
        pageService.deletePageById(id);
    }

    @PutMapping("/editPage/{id}")
    public PageDto editPage(@PathVariable(value = "id")Long id, @RequestBody Page page){
        return pageService.editPage(id,page);
    }


    //custom
    @GetMapping("/getAllBooksOfAuthor")
    public List<BookDto> getAllBooksOfAuthor(@RequestBody Author author) {
        return bookService.getAllBooksOfAuthor(author);
    }

    @GetMapping("/findAuthorsByPage/{id}")
    public List<Author> findAuhtorsByPage(@PathVariable(value = "id") Long id){
        return authorService.findAuthorsByPage(id);
    }

    @GetMapping("/findAllAuthorsBooksByPage/{id}")
    public List<Book> findAllAuthorsBooksByPage(@PathVariable(value = "id") Long id){
        return bookService.findAllAuthorsBooksByPage(id);
    }


    @GetMapping("/findPagesByAuthor/{id}")
    public List<Page> findPagesByAuthor(@PathVariable(value = "id") Long id,
                                        @Min(0) @RequestParam(value = "n", required = false) Long n){
        return Optional.ofNullable(n)
                .map(limit -> pageService.findNPagesByAuthor(id,limit))
                .orElse(pageService.findPagesByAuthor(id));
    }

}