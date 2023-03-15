package com.bookStore.demo.exceptions.advices;

import com.bookStore.demo.exceptions.PageIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PageNotFoundInAnyBookAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(PageIdNotFoundException.class)
    public String pageNotFoundInAnyBookHandler(PageIdNotFoundException pageIdNotFoundException){
        return pageIdNotFoundException.getMessage();
    }
}
