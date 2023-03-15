package com.bookStore.demo.services.implementations;

import com.bookStore.demo.models.dtos.PageDto;
import com.bookStore.demo.models.entities.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPageService {
    PageDto addPage(Page page);
    void deletePageById(Long id);
    PageDto editPage(Long id, Page editedPage);
    PageDto getPageById(Long id);
    List<Page> findPagesByAuthor(Long id);
    List<Page> findNPagesByAuthor(Long id,Long n);
}
