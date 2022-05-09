package com.libRest.libRestAPI.web;

import com.libRest.libRestAPI.entity.Books;
import com.libRest.libRestAPI.exceptions.RecordingNotFoundException;
import com.libRest.libRestAPI.model.BooksModel;
import com.libRest.libRestAPI.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    @Autowired
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/list")
    public ResponseEntity listBooks(){

        try {
            return ResponseEntity.ok(booksService.listBooks());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/listIds")
    public ResponseEntity listBooksIds(){

        try{
            return ResponseEntity.ok(booksService.listBooksIds());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Books newBook, @RequestParam Long bookTypeId){

        try{
            booksService.addBook(newBook, bookTypeId);
            return ResponseEntity.ok("New book added successfully!");
        }catch (RecordingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Unhandled exception!");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecordById(@PathVariable Long id){

        try{
            booksService.deleteBookById(id);
            return ResponseEntity.ok("Book with id = " + id + " deleted successfully!");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editBook(@RequestBody Books bookDetails, @PathVariable Long id){

        try {
            Books updatedBook = booksService.editBook(id, bookDetails);
            return ResponseEntity.ok(updatedBook);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/search")
    public ResponseEntity findByTitle(@RequestParam String title){

        try{
            List<BooksModel> booksModel = booksService.findByName(title);
            return ResponseEntity.ok().body(booksModel);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/searchByType")
    public ResponseEntity findAllByType(@RequestParam String typeName){

        try {
            List<BooksModel> booksModels = booksService.findAllByTypeName(typeName);
            return ResponseEntity.ok().body(booksModels);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
