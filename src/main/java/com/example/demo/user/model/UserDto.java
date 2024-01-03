package com.example.demo.user.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String email;
    private String password;

}


