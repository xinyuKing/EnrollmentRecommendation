package com.xinyu.service.Impl;

import com.xinyu.domain.entity.MajorEntity;
import com.xinyu.domain.param.MajorCondition;
import com.xinyu.mapper.MajorMapper;
import com.xinyu.service.IMajorService;
import com.xinyu.utils.parse.QueryModel;
import com.xinyu.utils.parse.QueryModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements IMajorService {

    @Autowired
    private MajorMapper mapper;

    @Override
    public List<MajorEntity> getList(QueryModel<MajorCondition> queryModel) {
        List<String> whereList = QueryModelParser.parseCondition(queryModel.getCondition(), "a");
        List<String> orderList = QueryModelParser.parseOrder(queryModel.getSorts(), MajorEntity.class, "a");
        return mapper.selectByParam(whereList,orderList,queryModel.getPaging());
    }
}
