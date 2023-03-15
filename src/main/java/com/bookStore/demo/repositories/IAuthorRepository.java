package com.bookStore.demo.repositories;

import com.bookStore.demo.models.entities.Author;
import com.bookStore.demo.models.entities.Page;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends CrudRepository<Author,Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM authors " +
            "WHERE id IN " +
            "(" +
            "SELECT books_authors.authors_id" +
            "    FROM " +
            "books_authors" +
            " JOIN books_pages ON books_authors.book_id = books_pages.book_id " +
            "WHERE books_pages.pages_id = ?1)")
    List<Author> findAuhtorsByPage(@NonNull Long id);
}
