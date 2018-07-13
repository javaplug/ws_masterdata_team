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

@Entity
@Table(name = "TEAM_MEMBER")
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Boolean getBillable() {
        return billable;
    }

    public void setBillable(Boolean billable) {
        this.billable = billable;
    }

    public OffsetDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(OffsetDateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getString() {
        return String;
    }

    public void setString(String string) {
        String = string;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
