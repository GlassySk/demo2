package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.service.impl.MybitUserSerimpl;
import com.example.demo2.util.VerifyCodeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/mybuser")
public class MybitUsertest {

    @PostMapping("/getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //验证码放入session
        session.setAttribute("code",code);
        System.out.println("code"+session.getAttribute("code"));
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(220,60,os,code);
    }
    @PostMapping("/code")
    public void codese(HttpSession session, HttpServletResponse response) throws IOException {

        //验证码session
        System.out.println("code"+session.getAttribute("code"));
    }
}
