package com.example.qnp.ratelimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateLimitService {
    
    @Autowired
    private RateLimitRepository rateLimitRepository;

    public Integer getCountByUrl(String url){
        return this.rateLimitRepository.getCountByUrl(url);
    }

    public RateLimitEntity save(String requestURI) {
        RateLimitEntity tmp = new RateLimitEntity( requestURI);
        return this.rateLimitRepository.save(tmp);
    }

    public void del(String id) {
        this.rateLimitRepository.deleteById(id);
    }
}
