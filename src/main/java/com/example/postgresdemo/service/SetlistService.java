package com.example.postgresdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresdemo.dao.SetlistDao;
import com.example.postgresdemo.model.SetlistModel;

@Service
public class SetlistService {
	
	@Autowired
	private SetlistDao setlistDao;
	
	public SetlistModel save(SetlistModel setlist) throws Exception {
		return setlistDao.save(setlist);
	}
	
	public SetlistModel findById(Long id) throws Exception {
		return setlistDao.findById(id).get();
	}
	
	public List<SetlistModel> findAll() throws Exception {
		return setlistDao.findAll();
	}
	
	public void deleteSetlist(Long id) throws Exception {
		SetlistModel sm = this.findById(id);
		setlistDao.delete(sm);
	}
}
