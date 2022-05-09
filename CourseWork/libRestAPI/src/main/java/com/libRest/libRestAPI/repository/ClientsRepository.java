package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Clients;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findAll();
    List<Clients> findAllByFirstName(String firstName);

}
