package com.xinyu.service;

import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityParam;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUniversityService {
    List<UniversityEntity> getList(UniversityParam param);
}
