package com.example.postgresdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.postgresdemo.transaction.PerformedSetlist;

public interface PerformedSetlistDao extends CrudRepository<PerformedSetlist, Long> {

}
