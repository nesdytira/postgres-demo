package com.example.postgresdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.transaction.PerformMember;

public interface PerformMemberDao extends CrudRepository<PerformMember, Long> {
	//public List<PerformMember> findByScheduleTeatherID(Long id);
}
