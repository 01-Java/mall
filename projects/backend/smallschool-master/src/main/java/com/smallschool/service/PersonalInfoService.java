package com.smallschool.service;

import com.smallschool.entity.PersonalInfo;
import com.smallschool.mapper.PersonalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInfoService {
    @Autowired
    private PersonalInfoMapper personalInfoMapper;
    public List<PersonalInfo> selectAll(){
        return personalInfoMapper.selectAll();
    }
}
