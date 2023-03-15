package com.bookStore.demo.services.implementations;
import com.bookStore.demo.models.dtos.AuthorDto;
import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthorService {
    AuthorDto createAuthor(Author author);
    AuthorDto editAuthor(Long authorId, Author author);
    AuthorDto getAuthorById(Long id);
    void deleteAuthorById(Long id);
    List<Author> findAuthorsByPage(Long id);
}
