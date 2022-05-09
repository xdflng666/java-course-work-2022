package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.BookTypes;
import com.libRest.libRestAPI.model.idModels.BookTypesIdModel;
import com.libRest.libRestAPI.repository.BookTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookTypesServiceImpl implements BookTypesService{
    @Autowired
    BookTypesRepository bookTypesRepository;

    @Override
    public List<BookTypes> listBookTypes() {
//        return (List<BookTypes>) bookTypesRepository.findAll();
        return bookTypesRepository.findAll(Sort.by("name"));
    }

    @Override
    public List<BookTypesIdModel> listBookTypesIds() {
        return bookTypesRepository.findAll().stream().map(BookTypes::toIdModel).collect(Collectors.toList());
    }

    @Override
    public BookTypes addBookType(BookTypes newBookType) {
        return bookTypesRepository.save(newBookType);
    }

    @Override
    public Long deleteBookTypeById(Long id) {
        bookTypesRepository.deleteById(id);
        return id;
    }

    @Override
    public BookTypes editBookType(Long id, BookTypes bookTypeDetails) {

        BookTypes bookType = bookTypesRepository.findById(id).get();

        bookType.setName(bookTypeDetails.getName());
        bookType.setCnt(bookTypeDetails.getCnt());
        bookType.setFine(bookTypeDetails.getFine());
        bookType.setDay_count(bookTypeDetails.getDay_count());

        return bookTypesRepository.save(bookType);

    }

}
