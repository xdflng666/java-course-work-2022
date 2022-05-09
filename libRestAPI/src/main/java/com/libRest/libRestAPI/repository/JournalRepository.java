package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {

    List<Journal> findAll();

    @Query("SELECT u FROM Journal u WHERE u.date_end < u.date_ret")
    List<Journal> findDebtors();

    @Query("SELECT c FROM Journal c WHERE c.clientId.firstName = :name")
    List<Journal> findAllByFirstName(@Param("name") String firstName);

//    @Query("SELECT b FROM Books b WHERE b.typeId.name = :name")
//    List<Books> findAllByTypeName(@Param("name") String typeName);
}
