package com.example.postgresdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.TeamDao;
import com.example.postgresdemo.model.TeamModel;

@Service
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	//Save Team
	public TeamModel saveTeam(TeamModel team) throws Exception {
		return teamDao.save(team);
	}
	
	//Get Team
	public TeamModel findById(Long id) throws Exception {
		return teamDao.findById(id).get();
	}
	
	//Delete Team
	public void deleteTeam(Long id) throws Exception{
		TeamModel t = this.findById(id);
		teamDao.delete(t);
	}
}
