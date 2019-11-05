package com.example.postgresdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.PerformedSetlistDao;
import com.example.postgresdemo.transaction.PerformedSetlist;

@Service
public class PerformedSetlistService {
	
	@Autowired
	private PerformedSetlistDao perf;
	
	//save
	public PerformedSetlist save(PerformedSetlist p) throws Exception {
		return perf.save(p);
	}
	
	//get
	public PerformedSetlist getByID(Long id) throws Exception {
		return perf.findById(id).get();
	}
	
	//add counts
	public PerformedSetlist addCounts(PerformedSetlist p) throws Exception{
		p.setShowCount(p.getShowCount()+1);
		return perf.save(p);
	}
}
