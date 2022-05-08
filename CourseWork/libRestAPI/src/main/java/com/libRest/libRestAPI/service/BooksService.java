package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.Books;
import com.libRest.libRestAPI.model.BooksModel;
import com.libRest.libRestAPI.model.idModels.BooksIdModel;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {

    List<BooksModel> listBooks();

    List<BooksIdModel> listBooksIds();

    Books addBook(Books book, Long bookTypeId);

    List<BooksModel> findByName(String name);

    Long deleteBookById(Long id);
}
