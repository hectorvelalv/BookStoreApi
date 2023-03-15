package com.bookStore.demo.exceptions;

public class PageIdNotFoundException extends RuntimeException{
    public PageIdNotFoundException() {
        super("Page id not found");
    }
}
