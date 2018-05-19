package com.spark.masterdata.team.service;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamServiceHelper {

    public List<TeamDTO> convert(List<Team> teams){
        List<TeamDTO> TeamDTOs = new ArrayList();
        for(Team team : teams){
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(team.getId());
            teamDTO.setName(team.getName());
            teamDTO.setCurrentProject(team.getCurrentProject());
            TeamDTOs.add(teamDTO);
        }
        return TeamDTOs;
    }

}
