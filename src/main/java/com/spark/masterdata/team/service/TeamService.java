package com.spark.masterdata.team.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.repository.TeamRepository;
import com.spark.masterdata.team.service.helper.TeamServiceHelper;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamServiceHelper teamServiceHelper;

    public List<TeamDTO> retrieveAllTeams() {
        return teamServiceHelper.convert((List<Team>) teamRepository.findAll());
    }

    public TeamDTO get(Integer teamId) {
        return teamRepository.findById(teamId)
                             .map(teamServiceHelper::unmarshallTeamDTO)
                             .orElse(null);
    }

    @Transactional
    public String saveTeam(TeamDTO teamDTO) {
        Team team;
        String message;
        if (NumberUtils.isCreatable(teamDTO.getTeamId())) {
            team = teamRepository.findById(NumberUtils.createInteger(teamDTO.getTeamId()))
                                 .orElse(new Team());
            message = "Team is successfully Updated";
        } else {
            team = new Team();
            message = "Team is successfully Created";
        }

        teamServiceHelper.marshallTeamDTO(teamDTO, team);
        teamRepository.save(team);
        return message;
    }

    @Transactional
    public void delete(Integer teamId) {
        teamRepository.findById(teamId)
                      .ifPresent(teamRepository::delete);
    }
}
