package com.spark.masterdata.team.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.spark.masterdata.team.dto.ResponseDTO;
import com.spark.masterdata.team.dto.TeamDTO;
import com.spark.masterdata.team.service.TeamService;
import com.spark.masterdata.team.validator.TeamValidator;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamValidator teamValidator;
    private final TeamService teamService;
    
    public TeamController(TeamValidator teamValidator, TeamService teamService) {
        this.teamValidator = teamValidator;
        this.teamService = teamService;
    }

    @GetMapping("/getAll")
    public List<TeamDTO> getAllTeams() {
        return teamService.retrieveAllTeams();
    }

    @GetMapping("/get/{teamId}")
    public TeamDTO getTeam(@PathVariable Integer teamId) {
        return teamService.get(teamId);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createTeam(@Valid @RequestBody TeamDTO teamDTO) {
        ResponseDTO responseDTO = teamValidator.valid(teamDTO);
        HttpStatus httpStatus;
        if (responseDTO.getErrors().isEmpty()) {
            String successMessage = teamService.saveTeam(teamDTO);
            responseDTO.setMessage(successMessage);
            httpStatus = HttpStatus.CREATED;
        } else {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateTeam(@Valid @RequestBody TeamDTO teamDTO) {
        ResponseDTO responseDTO = teamValidator.valid(teamDTO);
        HttpStatus httpStatus;
        if (responseDTO.getErrors().isEmpty()) {
            String successMessage = teamService.saveTeam(teamDTO);
            responseDTO.setMessage(successMessage);
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseDTO, httpStatus);
    }

    @DeleteMapping("/delete/{teamId}")
    public HttpStatus delete(@PathVariable Integer teamId) {
        teamService.delete(teamId);
        return HttpStatus.NO_CONTENT;
    }

}
