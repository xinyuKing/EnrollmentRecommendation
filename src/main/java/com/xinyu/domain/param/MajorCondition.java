package com.xinyu.domain.param;


import com.xinyu.utils.parse.ClauseOperator;
import com.xinyu.utils.parse.ConditionOperator;
import lombok.Data;


@Data
public class MajorCondition {

    @ConditionOperator(name = "major_id",operator = ClauseOperator.Equal)
    private String majorId;

    @ConditionOperator(name = "major_name",operator = ClauseOperator.Like)
    private String majorName;

    @ConditionOperator(name = "major_code",operator = ClauseOperator.Equal)
    private String majorCode;

    @ConditionOperator(name = "major_desc",operator = ClauseOperator.Like)
    private String majorDesc;

    @ConditionOperator(name = "need_subject",operator = ClauseOperator.Equal)
    private Integer needSubject;

    @ConditionOperator(name = "is_deleted",operator = ClauseOperator.Equal)
    private Integer isDeleted;
}
