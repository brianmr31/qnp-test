package com.example.qnp.ratelimit;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class RateLimitFilter implements Filter{

    private static final int LIMIT_RATE = 10;

    @Autowired
    private RateLimitService rateLimitService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
            throws IOException, ServletException {
        HttpServletRequest reqser = (HttpServletRequest) req;
        HttpServletResponse resser = (HttpServletResponse) res;

        System.out.println( "req "+reqser.getRequestURI() );
        Integer count = this.rateLimitService.getCountByUrl( reqser.getRequestURI() );
        RateLimitEntity tmp = null;
        if( count < LIMIT_RATE ){
            tmp = this.rateLimitService.save( reqser.getRequestURI() );
            fc.doFilter(reqser, resser); // di Proses
        } else {
            resser.setStatus( 429 );
            fc.doFilter(reqser, resser); // di Proses
        }
        if( tmp != null || tmp.getUrl() != null  ){
            this.rateLimitService.del( tmp.getId() );
        }
        System.out.println( "res "+reqser.getContentType() );
    }     
}
