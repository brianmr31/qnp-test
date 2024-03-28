package com.example.qnp.ratelimit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RateLimitRepository extends JpaRepository<RateLimitEntity, String>{

    @Query("select count(1) from RateLimitEntity e ")
    Integer getCountByUrl(@Param("url")String url);
    
}
