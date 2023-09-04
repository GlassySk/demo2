package com.example.demo2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ToString
@Builder
@Data
@Table(name="user")
@ApiModel(description= "shiyan")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "user")//指定表名
public class User implements Serializable {
    private static final long serialVersionUID = -5644799954031156649L;

    private String id;
    private String userName;
    private String passWord;
    private String realName;
    private List<String> all1;
    public List<String> getAll1() {
        return all1;
    }
    public void setAll1() {
        String[] userData = {userName, passWord, realName};
        all1 = Arrays.asList(userData);
    }
}