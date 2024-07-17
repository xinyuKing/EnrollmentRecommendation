package com.xinyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinyu.domain.entity.MajorEntity;
import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.utils.parse.Paging;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorMapper extends BaseMapper<MajorEntity> {
    List<MajorEntity> selectByParam(@Param("whereList") List<String> whereList, @Param("orderList") List<String> orderList, @Param("paging") Paging paging);
}
