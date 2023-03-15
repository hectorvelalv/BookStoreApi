package com.bookStore.demo.repositories;

import com.bookStore.demo.models.entities.Page;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageRepository extends CrudRepository<Page,Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM pages " +
            "WHERE id IN " +
            "(" +
            "SELECT books_pages.pages_id" +
            "    FROM " +
            "books_pages" +
            "        JOIN books_authors ON books_pages.book_id = books_authors.book_id " +
            "WHERE books_authors.authors_id = ?1)")
    List<Page> findPagesByAuthor(@NonNull Long id);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM pages " +
            "WHERE id IN " +
            "(" +
            "SELECT pages_id" +
            " FROM " +
            " books_pages AS bp join " +
            " books_authors AS ba ON bp.book_id=ba.book_id join " +
            " authors ON authors_id=id " +
            "WHERE id= ?1) limit ?2;")
    List<Page> findPagesByAuthor(@NonNull Long id, @Positive Long n);
}
