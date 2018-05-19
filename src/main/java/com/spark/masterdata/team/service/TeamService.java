package com.spark.masterdata.team.service;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    TeamServiceHelper teamServiceHelper = new TeamServiceHelper();

    public List<TeamDTO> retrieveAllTeams() {
        return teamServiceHelper.convert((List<Team>) teamRepository.findAll());
    }

    public Team addTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setCurrentProject(teamDTO.getCurrentProject());
        Team addedTeam = teamRepository.save(team);
        return addedTeam;
    }
}
