package com.example.qnp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.qnp.Message;
import com.example.qnp.entities.UserEntity;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    // @CrossOrigin( origins="http://localhost:4200")
    @GetMapping("/user/{pageNumber}/{pageSize}/{sort}")
    public Page < UserEntity > findAllPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, 
        @PathVariable String sort) {
        PageRequest pageable = null;
        if ( sort != null) {
            // with sorting
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
        } else {
            // without sorting
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        
        Page < UserEntity > data = userService.findAllDto( pageable );
        return data;
    }

    @PostMapping("/user/")
    public UserEntity saveUser(@RequestBody UserEntity user ){
       return this.userService.save( user );
    }

    @GetMapping("/user/{id}")
    public Message getUserById( @PathVariable String id ){
        return this.userService.getUserByid( id );
    }

    @DeleteMapping("/user/{id}")
    public Message delUserById( @PathVariable String id ){
        return this.userService.delUserByid( id);
    }

    @GetMapping("/user/init")
    public Message init(){
        return this.userService.init();
    }

    @GetMapping("/user/lemot")
    public Message lemot(){
        return this.userService.lemot();
    }
}
