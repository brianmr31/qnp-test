package com.example.qnp.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.qnp.entities.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, String>{

    @Query(" select e from PostEntity e ")
    Page<PostEntity> findAllDto(PageRequest pageable);    
}