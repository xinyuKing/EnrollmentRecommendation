package com.xinyu.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university_major_config")
public class UniversityMajorConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "major_id")
    private Integer majorId;

    @Column(name = "university_id")
    private Integer universityId;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "university_major_desc")
    private String universityMajorDesc;
}
