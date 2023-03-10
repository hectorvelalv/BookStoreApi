package com.bookStore.demo.repositories;

import com.bookStore.demo.models.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<Book,Long> {

    List<Book> findByAuthor(String author);
}
