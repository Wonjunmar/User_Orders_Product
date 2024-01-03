package com.example.demo.user.service;

import com.example.demo.orders.model.Orders;
import com.example.demo.orders.model.OrdersDto;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import com.example.demo.user.model.PostCreateUserReq;
import com.example.demo.user.model.PostCreateUserRes;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void create(UserDto userDto) {

        userRepository.save(User.builder()
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build());
    }

//    public PostCreateUserRes createM(PostCreateUserReq request) {
//
//        User user = User.builder()
//                .password(request.getPassword())
//                .email(request.getEmail())
//                .build();
//
//
//        User result = userRepository.save(user);
//
//        PostCreateUserRes response = PostCreateUserRes.builder()
//                .id(result.getId())
//                .email(result.getEmail())
//                .build();
//
//        return response;
//    }

    public List<UserDto> list() {
        List<User> result = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : result) {

            UserDto userDto = UserDto.builder()
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();
            userDtos.add(userDto);
        }
        return userDtos;
    }


    public void update(UserDto userDto) {
        userRepository.save(User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build());
    }

    public void delete(String email) {
        userRepository.delete(User.builder().email(email).build());
    }
}
