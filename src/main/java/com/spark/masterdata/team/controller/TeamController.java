package com.spark.masterdata.team.controller;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;


    @GetMapping("/hello")
    public String index() {
        return "Hello World Spring !";
    }

    @GetMapping("/getAllTeams")
    public List<TeamDTO> getAllTeams() {
        return teamService.retrieveAllTeams();
    }

    @PostMapping("/addTeam")
    public Team createTeam(@Valid @RequestBody TeamDTO teamDTO) {
        return teamService.addTeam(teamDTO);
    }

}
