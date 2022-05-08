package com.libRest.libRestAPI.web;

import com.libRest.libRestAPI.entity.BookTypes;
import com.libRest.libRestAPI.service.BookTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookTypes")
public class BookTypesController {

    private BookTypesService bookTypesService;

    @Autowired
    public void setBookTypesService(BookTypesService bookTypesService) {
        this.bookTypesService = bookTypesService;
    }

    @GetMapping("/list")
    public ResponseEntity listBookTypes(){
        return ResponseEntity.ok(bookTypesService.listBookTypes());
    }

    @GetMapping("/listIds")
    public ResponseEntity listBookTypesIds(){

        try{
            return ResponseEntity.ok(bookTypesService.listBookTypesIds());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @PostMapping("/addBookType")
    public ResponseEntity addBookType(@RequestBody BookTypes newBookType){

        try{
            bookTypesService.addBookType(newBookType);
            return ResponseEntity.ok("New book type added successfully!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookTypeById(@PathVariable Long id) {

        try {
            bookTypesService.deleteBookTypeById(id);
            return ResponseEntity.ok("Book type with id = " + id + " deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
