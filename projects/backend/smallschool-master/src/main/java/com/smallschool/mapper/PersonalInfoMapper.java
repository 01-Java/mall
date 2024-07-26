package com.smallschool.mapper;

import com.smallschool.entity.PersonalInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonalInfoMapper {
    List<PersonalInfo> selectAll();
}
