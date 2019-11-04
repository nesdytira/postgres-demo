package com.example.postgresdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.model.TeamModel;

public interface TeamDao extends CrudRepository<TeamModel, Long> {

}
