package com.example.demo2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo2.enumtext.DesensitizationTypeEnum;
import com.example.demo2.util.TestJacksonSerialize;
import com.example.demo2.zhujie.Desensitization;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "tbl_hard_subsidy")//指定表名
public class TblHardSubsidy implements Serializable {
    private int id;
    private int uid;
    @Desensitization(type = DesensitizationTypeEnum.CHINESE_NAME)
    private String name;
    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String mobile;
    private String idCardType;
    @Desensitization(type = DesensitizationTypeEnum.ID_CARD)
    private String idCard;
    private String sex;
    @Desensitization(type = DesensitizationTypeEnum.ADDRESS)
    private String address;
    private String content;
    private String picture;
    private String bank;
    private String account;
    private BigDecimal grantMoney;
    private Timestamp createTime;
    private String handler;
    private String status;
    private String flowNo;
}

