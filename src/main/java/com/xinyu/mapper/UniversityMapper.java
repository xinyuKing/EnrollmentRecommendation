package com.xinyu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.utils.parse.Paging;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UniversityMapper extends BaseMapper<UniversityEntity> {
    List<UniversityEntity> selectByParam(@Param("whereList") List<String> whereList, @Param("orderList") List<String> orderList,@Param("paging") Paging paging);
}
