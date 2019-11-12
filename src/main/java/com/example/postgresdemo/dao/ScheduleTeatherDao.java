package com.example.postgresdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.transaction.ScheduleTeather;

public interface ScheduleTeatherDao extends CrudRepository<ScheduleTeather, Long> {
	public List<ScheduleTeather> findAll();
}
