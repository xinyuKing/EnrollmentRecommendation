package com.xinyu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityParam;
import com.xinyu.mapper.UniversityMapper;
import com.xinyu.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements IUniversityService {

    @Autowired
    private UniversityMapper mapper;

    @Override
    public List<UniversityEntity> getList(UniversityParam param) {
        return mapper.selectByParam(param);
    }
}
