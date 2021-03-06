package com.libRest.libRestAPI.service;

import java.util.List;

import com.libRest.libRestAPI.entity.Journal;
import com.libRest.libRestAPI.model.JournalModel;
import com.libRest.libRestAPI.model.idModels.JournalIdModel;

public interface JournalService {

    List<JournalModel> listJournal();

    List<JournalIdModel> listJournalIds();

    void addRecord(Journal recording, Long clientId, Long bookId);

    void clearDatabase();

    List<JournalModel> listDebtors();

    Journal editRecord(Long id, Journal recordDetails);

    void deleteRecordById(Long id);

    List<JournalModel> findAllByClientFirstName(String firstName);

}
