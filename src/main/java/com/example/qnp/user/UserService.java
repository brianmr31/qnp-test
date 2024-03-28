package com.example.qnp.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.qnp.Message;
import com.example.qnp.entities.UserEntity;

@Service
public class UserService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public Page<UserEntity> findAllDto( Pageable page ) {
        return this.userRepository.findAllDto(page);
    }

    public Message getUserByid(String id) {
        UserEntity tmp = this.userRepository.getUserByid( id );
        return new Message("ok", tmp);
    }

    public UserEntity save( UserEntity d ){
        UserEntity tmp = this.userRepository.save(d);
        return tmp;
    }

    public Message delUserByid( String id){
        this.userRepository.deleteById( id);
        return new Message("ok");
    }

    public Message init() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        UserEntity[] datas = restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, entity, UserEntity[].class).getBody();

        this.userRepository.saveAll( Arrays.asList(datas) );
        return new Message("ok - count "+datas.length);
    }

    public Message lemot() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Message("lemot banget");
    }

}
