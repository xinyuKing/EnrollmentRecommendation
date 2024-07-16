package com.xinyu.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityParam {
    private Integer universityId;

    private String universityName;

    private String universityCode;

    private String universityDesc;

    private Integer is211;

    private Integer is985;

    private Integer isDoubleClass;

    private Integer isPublic;

    private Integer isUndergraduate;

    private String province;

    private String city;

}
