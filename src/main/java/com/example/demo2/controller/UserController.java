package com.example.demo2.controller;
import com.example.demo2.common.ListResponseEntity;
import com.example.demo2.common.ResponseEntity;
import com.example.demo2.entity.User;
import com.example.demo2.service.impl.UserServiceimpl;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Resource
    private UserServiceimpl userService;

    //通过用户id获取用户所有信息
    //    http://localhost:8080/testBoot/getUser/1(此处1为要获取的id）
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    //    http://localhost:8080/testBoot/getUser?id=1(此处1为要获取的id）
    //    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String GetUser(@PathVariable int id) {
        return userService.getUserInfo(id).toString();
    }

    //通过用户id删除用户
    //    http://localhost:8080/testBoot/delete?id=1(此处1为要删除的id）
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userService.deleteById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
    //根据用户id更新用户信息
    //http://localhost:8080/testBoot/update?id=2&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
    //插入新用户
    //    http://localhost:8080/testBoot/insert?id=100&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.save(user);
    }
    //打印所有用户信息
    //    http://localhost:8080/testBoot/selectAll
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> ListUser() {
        return userService.selectAll();
    }
    @RequestMapping("/k")
    @ResponseBody
    public User k(){
        return userService.k();
    }
    @RequestMapping("/s")
    public String s(){
        String s = new String();
        s="string";
        System.out.println("fffffffffff");
        return s;
    }
    @GetMapping(value = "/userpage")
    public ResponseEntity<ListResponseEntity> userpage(@ApiParam(value = "当前页") @RequestParam(value = "id", required = false,defaultValue = "ou")String id,
                                                            @ApiParam(value = "当前页") @RequestParam(value = "page", required = false,defaultValue = "1")int page,
                                                       @ApiParam(value = "大小") @RequestParam(value = "size", required = false,defaultValue = "10") int size){
        ResponseEntity<ListResponseEntity> responseEntity = userService.userpage(page,size,id);
        return responseEntity;
    }

}