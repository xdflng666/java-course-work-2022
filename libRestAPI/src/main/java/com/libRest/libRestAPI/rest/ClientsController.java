package com.libRest.libRestAPI.rest;

import com.libRest.libRestAPI.entity.Clients;
import com.libRest.libRestAPI.exceptions.UserNotFoundException;
import com.libRest.libRestAPI.service.ClientsService;
import com.libRest.libRestAPI.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    private ClientsService clientsService;
    private JournalService journalService;

    @Autowired
    public void setClientsService(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/list")
    public ResponseEntity listClients(){
        return ResponseEntity.ok(clientsService.listClients());
    }

    @GetMapping("/listIds")
    public ResponseEntity listClientsIds(){
        try {
            return ResponseEntity.ok(clientsService.listClientsIds());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addClient")
    public ResponseEntity addClient(@RequestBody Clients newClient){

        try{
            clientsService.addClient(newClient);
            return ResponseEntity.ok("New client added successfully!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClientById(@PathVariable Long id){

        try{

            //TODO dadada
//            journalService.deleteRecordsByUserId(id);
            clientsService.deleteClientById(id);
            return ResponseEntity.ok("Client with id = " + id + " deleted successfully!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editClient(@RequestBody Clients clientDetails, @PathVariable Long id){

        try {
            Clients updatedClient = clientsService.editClient(id, clientDetails);
            return ResponseEntity.ok(updatedClient);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/search")
    public ResponseEntity findByFirstName(@RequestParam String name){

        try{
            List<Clients> clients = clientsService.findAllByFirstName(name);
            return ResponseEntity.ok().body(clients);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
