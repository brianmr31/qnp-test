package com.example.qnp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.qnp.Entities.PostEntity;
import com.example.qnp.Entities.UserEntity;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post/{pageNumber}/{pageSize}/{sort}")
    public Page < PostEntity > findAllPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, 
        @PathVariable String sort) {
        PageRequest pageable = null;
        if ( sort != null) {
            // with sorting
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
        } else {
            // without sorting
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        
        Page < PostEntity > data = postService.findAllDto( pageable );
        return data;
    }

    @GetMapping("/post/init")
    public Message init(){
        return this.postService.init();
    }
}
