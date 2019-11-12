package com.example.postgresdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.transaction.PerformMember;
import com.example.postgresdemo.transaction.ScheduleTeather;

public interface PerformMemberDao extends CrudRepository<PerformMember, Long> {
	public List<PerformMember> findByScheduleTeather(ScheduleTeather sch);
}
