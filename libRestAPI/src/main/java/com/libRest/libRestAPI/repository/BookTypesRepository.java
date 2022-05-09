package com.libRest.libRestAPI.repository;

import com.libRest.libRestAPI.entity.BookTypes;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookTypesRepository extends CrudRepository<BookTypes, Long> {

    List<BookTypes> findAll();

    List<BookTypes> findAll(Sort name);
}
