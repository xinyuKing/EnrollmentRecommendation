package com.xinyu.service;

import com.xinyu.domain.entity.MajorEntity;
import com.xinyu.domain.param.MajorCondition;
import com.xinyu.utils.parse.QueryModel;

import java.util.List;

public interface IMajorService {

    List<MajorEntity> getList(QueryModel<MajorCondition> queryModel);
}
