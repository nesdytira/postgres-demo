package com.example.postgresdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.ScheduleTeatherDao;
import com.example.postgresdemo.transaction.ScheduleTeather;

@Service
public class ScheduleTeatherService {
	
	@Autowired
	private ScheduleTeatherDao sch;
	
	public ScheduleTeather save(ScheduleTeather s) throws Exception {
		return sch.save(s);
	}
	
	public ScheduleTeather getByID(Long id) throws Exception {
		return sch.findById(id).get();
	}
}
