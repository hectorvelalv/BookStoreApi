package com.bookStore.demo.repositories;

import com.bookStore.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
