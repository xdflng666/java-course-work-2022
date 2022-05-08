package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.BookTypes;
import com.libRest.libRestAPI.model.idModels.BookTypesIdModel;

import java.util.List;

public interface BookTypesService {

    List<BookTypes> listBookTypes();

    List<BookTypesIdModel> listBookTypesIds();

    BookTypes addBookType(BookTypes newBookType);

    Long deleteBookTypeById(Long id);
}
