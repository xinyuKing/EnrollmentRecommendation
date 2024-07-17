package com.xinyu.controller;

import com.xinyu.domain.entity.MajorEntity;
import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.MajorCondition;
import com.xinyu.domain.param.UniversityCondition;
import com.xinyu.service.IMajorService;
import com.xinyu.utils.parse.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MajorController {
    @Autowired
    private IMajorService majorService;

    @PostMapping("/getmajor")
    public ResponseEntity<List<MajorEntity>> getUniversity(@RequestBody QueryModel<MajorCondition> queryModel){

        return ResponseEntity.ok(majorService.getList(queryModel));
    }
}
