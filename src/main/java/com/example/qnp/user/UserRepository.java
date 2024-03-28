package com.example.qnp.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.qnp.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    
    @Query(" select e from UserEntity e ")
    Page<UserEntity> findAllDto( Pageable page );

    @Query(" select e from UserEntity e where e.id = :id ")
    UserEntity getUserByid(@Param("id") String id);
}
