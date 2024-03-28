package com.example.qnp.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.qnp.Message;
import com.example.qnp.entities.PostEntity;

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
