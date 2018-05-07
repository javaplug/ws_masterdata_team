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
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	
	@RequestMapping("/hi")
	public String welcome() {
		return "Hi Teams!";
	}
	
		@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addWater(@RequestBody Team team) {
		
		teamRepository.save(team);
		return "details of the team is saved " + team.getName() + " " + team.getCurrentProject();
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteTeam(@PathVariable Integer id) {
		
		teamRepository.deleteById(id);
		return "Team with" +" "+id+" "+"deleted";
		
	}
	
	@RequestMapping("/getallteams")
	public List<Team> getAllTeams(){
	 List<Team> allteams=new ArrayList<>();
	teamRepository.findAll().forEach(allteams::add);

	return allteams;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/update/{id}")
	public String update(@RequestBody Team td,@PathVariable Integer id) {
		
		td.setCurrentProject(td.getCurrentProject());
		td.setName(td.getName());
		td.setId(id);
		teamRepository.save(td);
		return "details are updated" + td.getId() + " "+td.getName() +" "+ td.getCurrentProject();
	}	
}
