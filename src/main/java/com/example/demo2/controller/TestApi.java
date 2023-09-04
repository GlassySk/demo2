package com.example.demo2.controller;

import com.example.demo2.entity.TblHardSubsidy;
import com.example.demo2.service.impl.TblHardSubsidyimpl;
import com.example.demo2.util.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestApi {
    @Autowired
    TblHardSubsidyimpl tblHardSubsidyimpl;

    @GetMapping
    public TblHardSubsidy test(){
        TblHardSubsidy testDTO = new TblHardSubsidy();
        testDTO.setMobile("17677772345");
        return testDTO;
    }
    @GetMapping("/e")
    public List<TblHardSubsidy> Testceshi()
    {
        return tblHardSubsidyimpl.queryAll();
    }
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println(code);
        //验证码放入session
        session.setAttribute("code",code);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtils.outputImage(180,40,os,code);
    }
}
