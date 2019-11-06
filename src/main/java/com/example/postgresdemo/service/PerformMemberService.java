package com.example.postgresdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.PerformMemberDao;
import com.example.postgresdemo.model.MemberModel;
import com.example.postgresdemo.model.TeamModel;
import com.example.postgresdemo.transaction.PerformMember;
import com.example.postgresdemo.transaction.PerformedSetlist;
import com.example.postgresdemo.transaction.ScheduleTeather;

@Service
public class PerformMemberService {
	
	@Autowired
	private PerformMemberDao performMemberDao;
	
	public PerformMember save(PerformMember p) {
		return performMemberDao.save(p);
	}
	
	/*public List<PerformMember> findByScheduleID(Long id){
		return performMemberDao.findByScheduleTeatherID(id);
	}*/
	
	public Long getTeamBySchedule(ScheduleTeather sch) {
		
		PerformedSetlist perf = sch.getPerformedSetlist();
		TeamModel team = perf.getTeam();
		Long teamID = team.getTeamID();
		
		return teamID;
	}
	
	public void saveAllTeamMemberPerform(ScheduleTeather sch, List<MemberModel> memberTeam) {
		memberTeam.forEach(member -> saveMember(sch,member));
	}
	
	public PerformMember saveMember(ScheduleTeather sch, MemberModel member) {
		PerformMember p = new PerformMember();
		p.setMember(member);
		p.setScheduleTeather(sch);
		
		return performMemberDao.save(p);
	}
	
	public void deletePerformMember(Long id) {
		performMemberDao.deleteById(id);
	}
}
