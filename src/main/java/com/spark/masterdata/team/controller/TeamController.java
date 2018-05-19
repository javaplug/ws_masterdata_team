package com.spark.masterdata.team.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/getAll")
    public List<TeamDTO> getAllTeams() {
        return teamService.retrieveAllTeams();
    }

    @GetMapping("/get/{teamId}")
    public TeamDTO getTeam(@PathVariable Integer teamId) {
        return teamService.get(teamId);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> createTeam(@Valid @RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.saveTeam(teamDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@Valid @RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.saveTeam(teamDTO), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{teamId}")
    public HttpStatus delete(@PathVariable Integer teamId) {
        teamService.delete(teamId);
        return HttpStatus.NO_CONTENT;
    }

}
