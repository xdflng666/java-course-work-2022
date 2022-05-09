package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {

    List<Journal> findAll();

    @Query("SELECT u FROM Journal u WHERE u.date_end < u.date_ret")
    List<Journal> findDebtors();

}
