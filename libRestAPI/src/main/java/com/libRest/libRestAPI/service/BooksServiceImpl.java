package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.BookTypes;
import com.libRest.libRestAPI.entity.Books;
import com.libRest.libRestAPI.exceptions.RecordingNotFoundException;
import com.libRest.libRestAPI.model.BooksModel;
import com.libRest.libRestAPI.model.idModels.BooksIdModel;
import com.libRest.libRestAPI.repository.BookTypesRepository;
import com.libRest.libRestAPI.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BookTypesRepository bookTypesRepository;

    @Override
    public List<BooksModel> listBooks() {

        if(booksRepository.findAll().isEmpty()){
            throw new RuntimeException("There are no books yet!");
        }

        return booksRepository.findAll(Sort.by("name")).stream()
                .map(Books::toModel)
                .collect(Collectors.toList());

    }

    @Override
    public List<BooksIdModel> listBooksIds() {

        return booksRepository.findAll().stream().map(Books::toIdModel).collect(Collectors.toList());

    }

    @Override
    public Books addBook(Books book, Long bookTypeId) {

        Optional<BookTypes> optionalBookType = bookTypesRepository.findById(bookTypeId);

        if (optionalBookType.isPresent()){
            book.setTypeId(optionalBookType.get());
        }else {
            throw new RecordingNotFoundException("There is no book type with id = " + bookTypeId + "!");
        }

        return booksRepository.save(book);

    }

    @Override
    public List<BooksModel> findByName(String name) {

        if (booksRepository.findAllByName(name).isEmpty()){
            throw new RuntimeException("Book with title " + name + " not found!");
        }

        return booksRepository.findAllByName(name).stream()
                .map(Books::toModel)
                .collect(Collectors.toList());

    }

    @Override
    public Long deleteBookById(Long id) {
        booksRepository.deleteById(id);
        return id;
    }

    @Override
    public Books editBook(Long id, Books bookDetails) {

        Books book = booksRepository.findById(id).get();

        book.setName(bookDetails.getName());
        book.setCnt(bookDetails.getCnt());

        return booksRepository.save(book);

    }

    @Override
    public List<BooksModel> findAllByTypeName(String typeName) {


        if (booksRepository.findAllByTypeName(typeName).isEmpty()){
            throw new RuntimeException("There are no books with type " + typeName + "!");
        }

        return booksRepository.findAllByTypeName(typeName).stream()
                .map(Books::toModel)
                .collect(Collectors.toList());

    }
}
