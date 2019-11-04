package com.example.postgresdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.MemberDao;
import com.example.postgresdemo.model.MemberModel;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	//Save Member
	public MemberModel save(MemberModel member) throws Exception {
		return memberDao.save(member);
	}
	
	//Get Member
	public MemberModel findById(Long id) throws Exception {
		return memberDao.findById(id).get();
	}
	
	//Get Team Member
	public List<MemberModel> findByTeamID(Long teamId) throws Exception {
		return memberDao.findByTeamID(teamId);
	}
	
	public List<MemberModel> findAllMember() throws Exception {
		return memberDao.findAll();		
	}
}
