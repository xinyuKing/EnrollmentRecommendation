package com.xinyu.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score_line")
public class ScoreLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="university_id")
    private Integer universityId;

    @Column(name="major_id")
    private Integer majorId;

    @Column(name = "score_line")
    private Integer scoreLine;

    @Column(name = "year")
    private Integer year;

}
