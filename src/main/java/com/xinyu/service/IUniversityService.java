package com.xinyu.service;

import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityCondition;
import com.xinyu.utils.parse.QueryModel;

import java.util.List;


public interface IUniversityService {
    List<UniversityEntity> getList(QueryModel<UniversityCondition> queryModel);
}
