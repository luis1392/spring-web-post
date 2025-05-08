package com.spring_web.test_web.services;


import com.spring_web.test_web.dtos.PageRequest;
import com.spring_web.test_web.dtos.PageResponse;
import com.spring_web.test_web.dtos.PostRequest;
import com.spring_web.test_web.dtos.PostResponse;

public interface PageService {
    PageResponse create(PageRequest page);
    PageResponse readByTitle(String title);
    PageResponse update(PageRequest page, String title);
    void delete(String title);


    PostResponse createPost(PostRequest post);
    PageResponse deletePost(Long id);
}
