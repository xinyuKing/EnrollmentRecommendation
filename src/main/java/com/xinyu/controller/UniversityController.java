package com.xinyu.controller;

import com.xinyu.domain.entity.UniversityEntity;
import com.xinyu.domain.param.UniversityParam;
import com.xinyu.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UniversityController {

    @Autowired
    private IUniversityService universityService;

    @PostMapping("/getuniversity")
    public ResponseEntity<List<UniversityEntity>> getUniversity(@RequestBody UniversityParam universityParam){

        return ResponseEntity.ok(universityService.getList(universityParam));
    }

}
