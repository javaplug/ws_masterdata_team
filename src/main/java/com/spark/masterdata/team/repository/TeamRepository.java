package com.spark.masterdata.team.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spark.masterdata.team.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

}
