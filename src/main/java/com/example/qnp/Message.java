package com.example.qnp;

import com.example.qnp.Entities.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    
    private String message;
    private UserEntity obj;

    public Message(String message, UserEntity tmp) {
        this.message = message;
        this.obj = tmp;
    }

    public Message(String message) {
        this.message = message;
    }
}
