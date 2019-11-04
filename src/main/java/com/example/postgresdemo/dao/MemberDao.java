package com.example.postgresdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.model.MemberModel;

public interface MemberDao extends CrudRepository<MemberModel, Long> {
	public List<MemberModel> findByTeamID(Long teamId);
	public List<MemberModel> findAll();
}
