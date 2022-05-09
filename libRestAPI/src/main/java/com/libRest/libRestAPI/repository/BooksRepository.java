package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByName(String name);
    List<Books> findAll();

}
