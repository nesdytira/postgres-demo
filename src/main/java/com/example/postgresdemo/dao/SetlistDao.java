package com.example.postgresdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.model.SetlistModel;

public interface SetlistDao extends CrudRepository<SetlistModel, Long> {
	public List<SetlistModel> findAll();
}
