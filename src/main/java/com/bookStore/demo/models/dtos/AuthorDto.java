package com.bookStore.demo.models.dtos;

import com.bookStore.demo.models.entities.Book;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class AuthorDto {
    @NonNull
    private Long id;
    @NonNull
    private String name;

}
