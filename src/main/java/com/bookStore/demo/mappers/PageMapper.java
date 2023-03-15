package com.bookStore.demo.mappers;

import com.bookStore.demo.models.dtos.PageDto;
import com.bookStore.demo.models.entities.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper {

    PageMapper INSATNCE = Mappers.getMapper(PageMapper.class);

    PageDto pageToPageDto(Page page);
}
