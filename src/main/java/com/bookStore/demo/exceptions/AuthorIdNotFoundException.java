package com.bookStore.demo.exceptions;

public class AuthorIdNotFoundException extends RuntimeException{
    public AuthorIdNotFoundException() {
        super("Author id not found");
    }
}
