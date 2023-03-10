package com.bookStore.demo.repositories;

import com.bookStore.demo.models.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book,Long> {
}
