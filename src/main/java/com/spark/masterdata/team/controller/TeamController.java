
package com.spark.masterdata.team.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spark.masterdata.team.entity.Team;
import com.spark.masterdata.team.repository.TeamRepository;

@RestController
@RequestMapping("/team")

public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to Master Data Team Management!";
	}

	//CREATE
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMember(@RequestBody Team team) {
		teamRepository.save(team);
		return "Saved member details: " + team.getId() + " " + team.getName() + " " + team.getCurrentProject();

	}
	
	//READ
	@RequestMapping("/getallmembers")
	public List<Team> getAllMembers() {
		List<Team> allMembers = new ArrayList<>();
		teamRepository.findAll().forEach(allMembers::add);
		return allMembers;
	}

	//UPDATE
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String updateMember(@RequestBody Team team, @PathVariable Integer id) {
		team.setId(id);
		teamRepository.save(team);
		return "Updated member details: " + team.getId() + " " + team.getName() + " " + team.getCurrentProject();
	}

	
	//DELETE
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteMember(@PathVariable Integer id) {
		teamRepository.delete(id);
		return "Deleted member";
	}

}

