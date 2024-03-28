package com.example.qnp.post;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.qnp.Message;
import com.example.qnp.entities.PostEntity;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Page<PostEntity> findAllDto(PageRequest pageable) {
        return this.postRepository.findAllDto( pageable);
    }

    public Message init() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        PostEntity[] datas = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, PostEntity[].class).getBody();

        this.postRepository.saveAll( Arrays.asList( datas ) );
        return new Message("ok - count "+datas.length);
    }
}
