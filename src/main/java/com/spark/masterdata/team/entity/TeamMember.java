package com.spark.masterdata.team.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TEAM_MEMBER")
@Data
public class TeamMember implements Serializable {

    private static final long serialVersionUID = -4396567303660725509L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Integer empId;

    @Column(name = "BILLABLE")
    private Boolean billable;

    @Column(name = "DATE_OF_JOINING")
    private OffsetDateTime dateOfJoining;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "STATUS")
    private String String;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

}
