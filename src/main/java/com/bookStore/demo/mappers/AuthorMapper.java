package com.bookStore.demo.mappers;

import com.bookStore.demo.models.dtos.AuthorDto;
import com.bookStore.demo.models.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto authorToAuthorDto(Author author);
}
