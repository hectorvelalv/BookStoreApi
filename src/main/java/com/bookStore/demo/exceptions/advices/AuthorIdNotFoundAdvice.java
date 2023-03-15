package com.bookStore.demo.exceptions.advices;

import com.bookStore.demo.exceptions.AuthorIdNotFoundException;
import com.bookStore.demo.exceptions.BookIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AuthorIdNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AuthorIdNotFoundException.class)
    public String authorIdNotFoundHandler(AuthorIdNotFoundException authorIdNotFoundException){
        return authorIdNotFoundException.getMessage();
    }
}
