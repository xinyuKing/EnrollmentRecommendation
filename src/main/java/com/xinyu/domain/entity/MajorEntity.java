package com.xinyu.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "major")
public class MajorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private String majorId;

    @Column(name = "major_name")
    private String majorName;

    @Column(name = "major_code")
    private String majorCode;

    @Column(name = "major_desc")
    private String majorDesc;

    @Column(name = "need_subject")
    private Integer needSubject;

    @Column(name = "is_deleted")
    private Integer isDeleted;
}
