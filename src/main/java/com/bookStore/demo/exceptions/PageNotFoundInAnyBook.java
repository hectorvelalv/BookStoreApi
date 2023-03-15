package com.bookStore.demo.exceptions;

public class PageNotFoundInAnyBook extends RuntimeException{
    public PageNotFoundInAnyBook() {
        super("PAge not found in any book");
    }
}
