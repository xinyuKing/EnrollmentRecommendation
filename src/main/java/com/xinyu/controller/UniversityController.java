package com.xinyu.controller;

import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityCondition;
import com.xinyu.service.IUniversityService;
import com.xinyu.utils.parse.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UniversityController {

    @Autowired
    private IUniversityService universityService;

    @PostMapping("/getuniversity")
    public ResponseEntity<List<UniversityEntity>> getUniversity(@RequestBody QueryModel<UniversityCondition> queryModel){

        return ResponseEntity.ok(universityService.getList(queryModel));
    }

}
