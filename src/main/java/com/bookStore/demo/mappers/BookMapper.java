package com.bookStore.demo.mappers;
import com.bookStore.demo.models.dtos.BookDto;
import com.bookStore.demo.models.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "available", target = "available")
    BookDto bookToBookDto(Book book);
}
