package com.spark.masterdata.team.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team")
@Data
public class Team implements Serializable {

    private static final long serialVersionUID = 7989759922324043788L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "LEAD_ID")
    private Integer leadId;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "PROJECT_ID")
    private String projectId;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREDIT_POINTS")
    private Integer creditPoints;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeamMember> teamMembers = new HashSet<>();

}
