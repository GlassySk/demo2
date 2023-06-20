package com.example.demo2.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@ToString
@Builder
@Data
@Table(name="user")
@ApiModel(description= "shiyan")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}