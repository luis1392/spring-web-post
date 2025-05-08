package com.spring_web.test_web.services;

import com.spring_web.test_web.dtos.PageRequest;
import com.spring_web.test_web.dtos.PageResponse;
import com.spring_web.test_web.dtos.PostRequest;
import com.spring_web.test_web.dtos.PostResponse;
import com.spring_web.test_web.entities.PageEntity;
import com.spring_web.test_web.repositories.PageRepository;
import com.spring_web.test_web.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor

public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final UserRepository userRepository;
    @Override
    public PageResponse create(PageRequest page) {

        final var entity = new PageEntity();
        BeanUtils.copyProperties(page, entity);

        final var user = this.userRepository.findById(page.getUserId()).orElseThrow();

        entity.setDateCreation(LocalDateTime.now());
        entity.setUser(user);
        entity.setPosts(new ArrayList<>());

        var pageCreated = this.pageRepository.save(entity);
        final var pageResponse = new PageResponse();
        BeanUtils.copyProperties(pageCreated, pageResponse);
        return pageResponse;
    }


    @Override
    public PageResponse readByTitle(String title) {
        final var entityResponse = this.pageRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("title not found"));
        final var pageResponse = new PageResponse();
        BeanUtils.copyProperties(entityResponse, pageResponse);

        final List<PostResponse>  postResponses = entityResponse.getPosts()
                .stream()
                .map(postEntity ->
                     PostResponse.builder()
                            .img(postEntity.getImg())
                            .content(postEntity.getContent())
                            .dateCreation(postEntity.getDateCreation())
                             .build()
                ).toList();
        pageResponse.setPosts(postResponses);
        return pageResponse;
    }

    @Override
    public PageResponse update(PageRequest page, String title) {
        return null;
    }

    @Override
    public void delete(String title) {

    }

    @Override
    public PostResponse createPost(PostRequest post) {
       return null;
    }

    @Override
    public PageResponse deletePost(Long id) {
       return null;
    }
}
