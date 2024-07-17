package com.xinyu.domain.param;

import com.xinyu.utils.parse.ClauseOperator;
import com.xinyu.utils.parse.ConditionOperator;
import lombok.Data;


@Data
public class UniversityCondition {
    @ConditionOperator(name="university_id",operator= ClauseOperator.Equal)
    private Integer universityId;

    @ConditionOperator(name="university_name",operator= ClauseOperator.Like)
    private String universityName;

    @ConditionOperator(name="university_code",operator= ClauseOperator.Equal)
    private String universityCode;

    @ConditionOperator(name="university_desc",operator= ClauseOperator.Like)
    private String universityDesc;

    @ConditionOperator(name="is_211",operator= ClauseOperator.Equal)
    private Integer is211;

    @ConditionOperator(name="is_985l",operator= ClauseOperator.Equal)
    private Integer is985;

    @ConditionOperator(name="is_double_class",operator= ClauseOperator.Equal)
    private Integer isDoubleClass;

    @ConditionOperator(name="is_public",operator= ClauseOperator.Equal)
    private Integer isPublic;

    @ConditionOperator(name="is_undergraduate",operator= ClauseOperator.Equal)
    private Integer isUndergraduate;

    @ConditionOperator(name="is_province",operator= ClauseOperator.Equal)
    private String province;

    @ConditionOperator(name="city",operator= ClauseOperator.Equal)
    private String city;

}
