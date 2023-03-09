package com.bookStore.demo.exceptions;

public class BookIdNotFoundException extends RuntimeException{
    public BookIdNotFoundException() {
        super("Id Of the book not found");
    }
}
