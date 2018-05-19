package com.spark.masterdata.team.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.utility.DateUtility;

@Component
public class TeamServiceHelper {

    public List<TeamDTO> convert(List<Team> teams) {
        List<TeamDTO> TeamDTOs = new ArrayList<>();
        for (Team team : teams) {
            TeamDTOs.add(unmarshallTeamDTO(team));
        }
        return TeamDTOs;
    }

    public Team marshallTeamDTO(TeamDTO teamDTO, Team team) {
        team.setTeamName(teamDTO.getTeamName());
        if (NumberUtils.isCreatable(teamDTO.getLeadId())) {
            team.setLeadId(NumberUtils.createInteger(teamDTO.getLeadId()));
        }
        team.setLocation(teamDTO.getLocation());
        team.setProjectId(teamDTO.getProjectId());
        if (NumberUtils.isCreatable(teamDTO.getDuration())) {
            team.setDuration(NumberUtils.createInteger(teamDTO.getDuration()));
        }
        if (teamDTO.getStartDate() != null) {
            team.setStartDate(DateUtility.convertStringDate(teamDTO.getStartDate()));
        }
        team.setStatus(teamDTO.getStatus());
        if (NumberUtils.isCreatable(teamDTO.getCreditPoints())) {
            team.setCreditPoints(NumberUtils.createInteger(teamDTO.getCreditPoints()));
        }
        return team;
    }

    public TeamDTO unmarshallTeamDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        if (team.getTeamId() != null) {
            teamDTO.setTeamId(String.valueOf(team.getTeamId()));
        }
        teamDTO.setTeamName(team.getTeamName());
        if (team.getLeadId() != null) {
            teamDTO.setLeadId(String.valueOf(team.getLeadId()));
        }
        teamDTO.setLocation(team.getLocation());
        teamDTO.setProjectId(team.getProjectId());
        if (team.getDuration() != null) {
            teamDTO.setDuration(String.valueOf(team.getDuration()));
        }
        if (team.getStartDate() != null) {
            teamDTO.setStartDate(DateUtility.convertDateString(team.getStartDate()));
        }
        teamDTO.setStatus(team.getStatus());
        if (team.getCreditPoints() != null) {
            teamDTO.setCreditPoints(String.valueOf(team.getCreditPoints()));
        }
        return teamDTO;
    }
}
