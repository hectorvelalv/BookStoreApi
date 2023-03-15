package com.bookStore.demo.services.implementations;

import com.bookStore.demo.exceptions.AuthorIdNotFoundException;
import com.bookStore.demo.exceptions.PageIdNotFoundException;
import com.bookStore.demo.mappers.PageMapper;
import com.bookStore.demo.models.dtos.PageDto;
import com.bookStore.demo.models.entities.Page;
import com.bookStore.demo.repositories.IPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements IPageService{
    private final IPageRepository pageRepository;
    @Override
    public PageDto addPage(Page page) {
        return PageMapper.INSATNCE.pageToPageDto(pageRepository.save(page));
    }

    @Override
    public void deletePageById(Long id) {
        if(pageRepository.findById(id).isEmpty()) throw new PageIdNotFoundException();
        pageRepository.deleteById(id);
    }

    @Override
    public PageDto editPage(Long id, Page editedPage) {
        return pageRepository.findById(id).stream().map(pageFounded -> {
            editedPage.setId(pageFounded.getId());
            return PageMapper.INSATNCE.pageToPageDto(pageRepository.save(editedPage));
        }).findFirst().orElseThrow(PageIdNotFoundException::new);
    }

    @Override
    public PageDto getPageById(Long id) {
        return PageMapper.INSATNCE.pageToPageDto(pageRepository.findById(id).orElseThrow(PageIdNotFoundException::new));
    }

    @Override
    public List<Page> findPagesByAuthor(Long id) {
        return pageRepository.findPagesByAuthor(id);
    }

    @Override
    public List<Page> findNPagesByAuthor(Long id, Long n) {
        return pageRepository.findPagesByAuthor(id,n);
    }

}
