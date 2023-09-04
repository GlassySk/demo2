package com.example.demo2.service.impl;


import com.example.demo2.dao.TblHardSubsidy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TblHardSubsidyimpl {
    @Autowired
    TblHardSubsidy tblHardSubsidy;
    public List<com.example.demo2.entity.TblHardSubsidy> queryAll() {
        return tblHardSubsidy.selectList(null);
    }
}
