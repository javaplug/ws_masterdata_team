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
    public Team saveTeam(TeamDTO teamDTO) {
        Team team;
        if (NumberUtils.isCreatable(teamDTO.getTeamId())) {
            team = teamRepository.findById(NumberUtils.createInteger(teamDTO.getTeamId()))
                                 .orElse(new Team());
        } else {
            team = new Team();
        }

        teamServiceHelper.marshallTeamDTO(teamDTO, team);
        return teamRepository.save(team);
    }

    @Transactional
    public void delete(Integer teamId) {
        teamRepository.findById(teamId)
                      .ifPresent(teamRepository::delete);
    }
}
