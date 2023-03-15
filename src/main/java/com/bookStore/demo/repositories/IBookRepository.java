package com.bookStore.demo.repositories;

import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Book;
import com.bookStore.demo.models.entities.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBookRepository extends CrudRepository<Book,Long> {
    List<Book> findByAuthors(Author author);

    @Query(nativeQuery = true, value = "SELECT books.id,books.title ,books.available,books.price " +
            "FROM books " +
            "JOIN books_authors AS ba ON books.id = ba.book_id " +
            "JOIN authors ON ba.authors_id = authors.id " +
            "WHERE authors.id IN (" +
            "   SELECT ba.authors_id " +
            "   FROM books_authors AS ba " +
            "   JOIN books_pages AS bp ON bp.book_id = ba.book_id " +
            "WHERE bp.pages_id = ?1)")
    List<Book> findAllAuthorsBooksByPage(Long id);


}
