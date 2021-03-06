package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.Books;
import com.libRest.libRestAPI.entity.Clients;
import com.libRest.libRestAPI.entity.Journal;
import com.libRest.libRestAPI.exceptions.UserNotFoundException;
import com.libRest.libRestAPI.model.JournalModel;
import com.libRest.libRestAPI.model.idModels.JournalIdModel;
import com.libRest.libRestAPI.repository.BookTypesRepository;
import com.libRest.libRestAPI.repository.BooksRepository;
import com.libRest.libRestAPI.repository.ClientsRepository;
import com.libRest.libRestAPI.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BookTypesRepository bookTypesRepository;

    @Override
    public List<JournalModel> listJournal() {
        return  journalRepository.findAll().stream()
                .map(Journal::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<JournalIdModel> listJournalIds() {
        return journalRepository.findAll().stream().map(Journal::toIdModel).collect(Collectors.toList());
    }

    @Override
    public void addRecord(Journal newRecord, Long clientId, Long bookId) {

        Optional<Clients> optionalClient = clientsRepository.findById(clientId);
        Optional<Books> optionalBook = booksRepository.findById(bookId);

        if (optionalClient.isPresent() && optionalBook.isPresent())
        {
            newRecord.setClientId(optionalClient.get());
            newRecord.setBooks_id(optionalBook.get());
        }else {
            throw new UserNotFoundException("Client with id = " + clientId + " not found!");
        }

        newRecord.setDate_end(new Date(optionalBook.get().getTypeId().getDay_count() * 86400000L + newRecord.getDate_beg().getTime()));

        journalRepository.save(newRecord);
    }

    @Override
    public void clearDatabase() {
        journalRepository.deleteAll();
        booksRepository.deleteAll();
        bookTypesRepository.deleteAll();
    }

    @Override
    public List<JournalModel> listDebtors() {

        if (journalRepository.findDebtors().isEmpty()){
            throw new RuntimeException("There are no debtors yet!");
        }

        return journalRepository.findDebtors().stream().map(Journal::toModel).collect(Collectors.toList());
    }

    @Override
    public List<JournalModel> findAllByClientFirstName(String firstName) {

        if (journalRepository.findAllByFirstName(firstName).isEmpty()){
            throw new RuntimeException("There is no client with first name = " + firstName + "!");
        }

        return journalRepository.findAllByFirstName(firstName).stream().map(Journal::toModel).collect(Collectors.toList());
    }

    @Override
    public Journal editRecord(Long id, Journal recordDetails) {

        Journal editedRecord = journalRepository.findById(id).get();

        editedRecord.setDate_beg(recordDetails.getDate_beg());
        editedRecord.setDate_ret(recordDetails.getDate_ret());

        return journalRepository.save(editedRecord);

    }

    @Override
    public void deleteRecordById(Long id) {

        journalRepository.deleteById(id);

    }

}
