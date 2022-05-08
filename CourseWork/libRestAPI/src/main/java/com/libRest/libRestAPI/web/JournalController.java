package com.libRest.libRestAPI.web;

import com.libRest.libRestAPI.entity.Journal;
import com.libRest.libRestAPI.exceptions.UserNotFoundException;
import com.libRest.libRestAPI.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private JournalService journalService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/list")
    public ResponseEntity listJournal(){
        return ResponseEntity.ok(journalService.listJournal());
    }

    @GetMapping("/listIds")
    public ResponseEntity listJournalIds(){

        try {
            return ResponseEntity.ok(journalService.listJournalIds());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/addRecord")
    public ResponseEntity addRecord(@RequestBody Journal newRecord, @RequestParam Long clientId, @RequestParam Long bookId){

        try{
            journalService.addRecord(newRecord, clientId, bookId);
            return ResponseEntity.ok("New record added successfully!");
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @DeleteMapping("/clearDatabase")
    public ResponseEntity clearDatabase(){
        try {
            journalService.clearDatabase();
            return ResponseEntity.ok("Database dropped!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
