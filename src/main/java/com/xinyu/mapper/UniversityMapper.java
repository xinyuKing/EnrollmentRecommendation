package com.xinyu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UniversityMapper extends BaseMapper<UniversityEntity> {
    List<UniversityEntity> selectByParam(UniversityParam param);
}
