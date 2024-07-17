package com.xinyu.service.Impl;

import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityCondition;
import com.xinyu.mapper.UniversityMapper;
import com.xinyu.service.IUniversityService;
import com.xinyu.utils.parse.QueryModel;
import com.xinyu.utils.parse.QueryModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements IUniversityService {

    @Autowired
    private UniversityMapper mapper;

    @Override
    public List<UniversityEntity> getList(QueryModel<UniversityCondition> queryModel) {
        List<String> whereList = QueryModelParser.parseCondition(queryModel.getCondition(), "a");
        List<String> orderList = QueryModelParser.parseOrder(queryModel.getSorts(), UniversityEntity.class, "a");
        return mapper.selectByParam(whereList,orderList, queryModel.getPaging());
    }
}
