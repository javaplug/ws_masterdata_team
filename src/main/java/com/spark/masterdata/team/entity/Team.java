package com.spark.masterdata.team.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 7989759922324043788L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@Column(name = "current_project")
	private String currentProject;
}
