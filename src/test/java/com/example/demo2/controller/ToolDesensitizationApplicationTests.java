package com.example.demo2.controller;

import cn.hutool.core.util.DesensitizedUtil;
import org.junit.Test;

public class ToolDesensitizationApplicationTests {
    @Test
    public void contextLoads()
    {
        String phoneNumber="韩正洋";
        System.out.println(DesensitizedUtil.chineseName(phoneNumber));
    }
}
