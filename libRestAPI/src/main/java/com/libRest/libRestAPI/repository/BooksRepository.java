package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByName(String name);
    List<Books> findAll();

    @Query("SELECT b FROM Books b WHERE b.typeId.name = :name")
    List<Books> findAllByTypeName(@Param("name") String typeName);

}
