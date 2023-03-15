package com.bookStore.demo.services.implementations;

import com.bookStore.demo.exceptions.AuthorIdNotFoundException;
import com.bookStore.demo.mappers.AuthorMapper;
import com.bookStore.demo.models.dtos.AuthorDto;
import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.repositories.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService{
    private final IAuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(Author author) {
        return AuthorMapper.INSTANCE.authorToAuthorDto(authorRepository.save(author));
    }
    @Override
    public AuthorDto editAuthor(Long authorId, Author author) {
        return authorRepository.findById(authorId).stream().map(
                authFounded -> {
                    author.setId(authFounded.getId());
                    return AuthorMapper.INSTANCE.authorToAuthorDto(authorRepository.save(author));
                }).findFirst().orElseThrow(AuthorIdNotFoundException::new);
    }
    @Override
    public AuthorDto getAuthorById(Long id) {
        return AuthorMapper.INSTANCE.authorToAuthorDto(authorRepository.findById(id).orElseThrow(AuthorIdNotFoundException::new));
    }
    @Override
    public void deleteAuthorById(Long id) {

        if(authorRepository.findById(id).isEmpty()) throw new AuthorIdNotFoundException();
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAuthorsByPage(Long id) {
        return authorRepository.findAuhtorsByPage(id);
    }

//    @Override
//    public AuthorDto setBook(Long authorId, Book book) {
//        return authorRepository.findById(authorId).stream().map(
//                authFounded -> {
//                    List<Book> authorsBooks = authFounded.getBooks();
//                    authorsBooks.add(book);
//                    authFounded.setBooks(authorsBooks);
//                    return AuthorMapper.INSTANCE.authorToAuthorDto(authorRepository.save(authFounded));
//                }).findFirst().orElseThrow(AuthorIdNotFoundException::new);
//
//    }
}
