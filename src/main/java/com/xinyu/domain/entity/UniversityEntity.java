package com.xinyu.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university")
public class UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityId;

    @Column(name = "university_name")
    private String universityName;

    @Column(name="university_code")
    private String universityCode;

    @Column(name="university_desc")
    private String universityDesc;

    @Column(name="is_211")
    private int is211;

    @Column(name="is_985")
    private int is985;

    @Column(name="is_double_class")
    private int isDoubleClass;

    @Column(name="is_public")
    private int isPublic;

    @Column(name="is_undergraduate")
    private int isUndergraduate;

    @Column(name="province")
    private String province;

    @Column(name="city")
    private String city;

    @Column(name="is_deleted")
    private int isDeleted;

}
