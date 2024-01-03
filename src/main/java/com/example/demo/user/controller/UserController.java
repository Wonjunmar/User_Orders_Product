package com.example.demo.user.controller;

import com.example.demo.user.model.PostCreateUserReq;
import com.example.demo.user.model.PostCreateUserRes;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    JavaMailSender emailSender;

    public UserController(UserService memberService,JavaMailSender emailSender) {
        this.userService = memberService;
        this.emailSender = emailSender;
    }


//    @RequestMapping(method = RequestMethod.POST, value = "/createM")
//    public ResponseEntity createM(PostCreateUserReq request) {
//
//        PostCreateUserRes response = userService.createM(request);
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(request.getEmail());
//        message.setSubject("[wonjunmar] 이메일 인증");
//        String uuid = UUID.randomUUID().toString();
//        message.setText("http://localhost:8080/user/verify?email=" + request.getEmail()+ "&uuid=" + uuid);
//        emailSender.send(message);
//
//        return ResponseEntity.ok().body("생성");
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(UserDto userDto) {
//        userService.create();
        return ResponseEntity.ok().body("생성");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(userService.list());
    }


    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(UserDto userDto) {
        userService.update(userDto);

        return ResponseEntity.ok().body("수정");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(String email) {
        userService.delete(email);
        return ResponseEntity.ok().body("삭제");
                
    }
}
