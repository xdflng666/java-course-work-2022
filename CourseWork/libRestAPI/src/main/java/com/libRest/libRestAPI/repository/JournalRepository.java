package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Journal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {

    List<Journal> findAll();

}
