package org.libraryConsoleApp.rest;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.libraryConsoleApp.models.dialogModels.BookTypesIdModel;
import org.libraryConsoleApp.models.dialogModels.BooksIdModel;
import org.libraryConsoleApp.models.dialogModels.ClientsIdModel;
import org.libraryConsoleApp.models.dialogModels.JournalIdModel;
import org.libraryConsoleApp.models.getModels.BookTypes;
import org.libraryConsoleApp.models.getModels.Books;
import org.libraryConsoleApp.models.getModels.Clients;
import org.libraryConsoleApp.models.getModels.Journal;
import org.libraryConsoleApp.models.postModels.BooksPostModel;
import org.libraryConsoleApp.models.postModels.JournalPostModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class RequestSender {

    private static final Scanner consoleIn = new Scanner(System.in);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final String HOST_URL = "http://localhost:8080";


    // ==========UTILITIES==========
    private static void printClients(List<Clients> clientsList){

        System.out.println("===============================================Clients===============================================");
        System.out.printf("%2s  %-20s %-20s %-20s %-20s %-20s", "№", "First Name", "Last Name", "Pather Name", "Passport Seria", "Passport Num");
        System.out.println();

        for (int i = 0; i < clientsList.size(); i++) {
            System.out.printf("%2d. %-20s %-20s %-20s %-20s %-20s", i + 1, clientsList.get(i).getFirstName(), clientsList.get(i).getLastName(), clientsList.get(i).getPatherName(), clientsList.get(i).getPassportSeria(), clientsList.get(i).getPassportNum());
            System.out.println();
        }

    }

    private static void printBookTypes(List<BookTypes> bookTypesList){

        System.out.println("===================================Book Types===================================");
        System.out.printf("%2s %-20s %-20s %-20s %-20s", "№", "Name", "Count", "Fine", "Days Count");
        System.out.println();

        for (int i = 0; i < bookTypesList.size(); i++) {
            System.out.printf("%2d. %-20s %-20d %-20d %-20d", i + 1, bookTypesList.get(i).getName(), bookTypesList.get(i).getCnt(), bookTypesList.get(i).getFine(), bookTypesList.get(i).getDay_count());
            System.out.println();
        }

    }

    private static void printBooks(List<Books> booksList){

        System.out.println("===================================Books===================================");
        System.out.printf("%2s  %-30s %-20s %-20s", "№", "Name", "Pages", "Type");
        System.out.println();

        for (int i = 0; i < booksList.size(); i++) {
            System.out.printf("%2d. %-30s %-20d %-20s", i + 1, booksList.get(i).getName(), booksList.get(i).getCnt(), booksList.get(i).getTypeName());
            System.out.println();
        }

    }

    private static void printJournal(List<Journal> journalList){

        System.out.println("===============================================================================================Journal===============================================================================================");
        System.out.printf("%2s  %-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s", "№", "First Name", "Last Name", "Pather Name", "Book", "Pages", "Begin Date", "End Date", "Return Date");
        System.out.println();

        for (int i = 0; i < journalList.size(); i++) {
            System.out.printf("%2d. %-25s %-25s %-25s %-25s %-25d %-25s %-25s %-25s", i + 1, journalList.get(i).getFirst_name(), journalList.get(i).getLast_name(), journalList.get(i).getPather_name(), journalList.get(i).getBook_name(), journalList.get(i).getBook_cnt(), journalList.get(i).getDate_beg(), journalList.get(i).getDate_end(), journalList.get(i).getDate_ret());
            System.out.println();
        }

    }


    //===============REQUESTS===============
    private static void bookTypesIdDialog(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/bookTypes/listIds", String.class);
        List<BookTypesIdModel> bookTypesIdModels = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<BookTypesIdModel>>(){}.getType());

        System.out.println("===================================Book Types===================================");
        System.out.printf("%2s     %-10s %-20s ", "№", "ID", "Name");
        System.out.println();

        for (int i = 0; i < bookTypesIdModels.size(); i++) {
            System.out.printf("%2d.    %-10d %-20s", i + 1, bookTypesIdModels.get(i).getId() ,bookTypesIdModels.get(i).getName());
            System.out.println();
        }

    }

    private static void booksIdDialog(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/books/listIds", String.class);
        List<BooksIdModel> booksIdModels = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<BooksIdModel>>(){}.getType());

        System.out.println("=====================================Books=====================================");
        System.out.printf("%2s    %-5s %-20s %-20s", "№", "ID", "Name", "Type");
        System.out.println();

        for (int i = 0; i < booksIdModels.size(); i++) {
            System.out.printf("%2d.   %-5d %-20s %-20s", i + 1, booksIdModels.get(i).getId(), booksIdModels.get(i).getName(), booksIdModels.get(i).getTypeName());
            System.out.println();
        }

    }

    private static void clientsIdDialog(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/clients/listIds", String.class);
        List<ClientsIdModel> clientsIdModels = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<ClientsIdModel>>(){}.getType());

        System.out.println("=====================================Clients=====================================");
        System.out.printf("%2s    %-5s  %-20s %-20s", "№", "ID", "First Name", "Last Name", "Pather Name");
        System.out.println();

        for (int i = 0; i < clientsIdModels.size(); i++) {
            System.out.printf("%2d.   %-5d  %-20s %-20s", i + 1, clientsIdModels.get(i).getId(), clientsIdModels.get(i).getLastName(), clientsIdModels.get(i).getPatherName());
            System.out.println();
        }

    }

    private static void journalIdDialog(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/journal/listIds", String.class);
        List<JournalIdModel> journalIdModels = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<JournalIdModel>>(){}.getType());

        System.out.println("======================================================================Journal======================================================================");
        System.out.printf("%2s     %-5s  %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "№", "ID", "First Name", "Last Name", "Pather Name", "Title", "Date Beg", "Date End", "Date Ret");
        System.out.println();

        for (int i = 0; i < journalIdModels.size(); i++) {
            System.out.printf("%2d.    %-5s  %-20s %-20s %-20s %-20s %-20s %-20s %-20s", i + 1, journalIdModels.get(i).getId(), journalIdModels.get(i).getFirstName(), journalIdModels.get(i).getLastName(), journalIdModels.get(i).getPatherName(), journalIdModels.get(i).getBookName(), journalIdModels.get(i).getDateBeg(), journalIdModels.get(i).getDateEnd(), journalIdModels.get(i).getDateRet());
            System.out.println();
        }

    }

    public static void getClients(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/clients/list", String.class);
        List<Clients> clientsList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Clients>>(){}.getType());

//        if (clientsList.size() < 1){
//            System.out.println("There are no clients yet!");
//            return;
//        }

        printClients(clientsList);

    }

    public static void getBookTypes(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/bookTypes/list", String.class);
        List<BookTypes> bookTypesList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<BookTypes>>(){}.getType());

        if (bookTypesList.size() < 1){
            System.out.println("There are no book types yet!");
            return;
        }

        printBookTypes(bookTypesList);

    }

    public static void getBooks(){

        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/books/list", String.class);
            List<Books> booksList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Books>>(){}.getType());
            printBooks(booksList);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void listJournal(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/journal/list", String.class);
        List<Journal> journalList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Journal>>(){}.getType());

        if (journalList.size() < 1){
            System.out.println("There are no records yet!");
            return;
        }

        printJournal(journalList);

    }

    public static void addRecord(){

        try {
            System.out.println("Creating record:");

            clientsIdDialog();
            System.out.print("Type client's ID to be assigned: ");
            long clientId = consoleIn.nextLong();

            booksIdDialog();
            System.out.print("Type book's ID to be assigned: ");
            long bookId = consoleIn.nextLong();

            System.out.println("Type Beg Date in format dd/MM/yyyy: ");
            String dateBeg = consoleIn.next();
            System.out.println("Type Ret Date in format dd/MM/yyyy: ");
            String dateRet = consoleIn.next();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            JournalPostModel journalPostModel = new JournalPostModel(simpleDateFormat.parse(dateBeg).getTime(), simpleDateFormat.parse(dateRet).getTime());
            String json = GSON.toJson(journalPostModel);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(HOST_URL + "/journal/addRecord?clientId=" + clientId + "&bookId=" + bookId, request, String.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void addClient(){

        try {
            System.out.println("Creating client:");
            System.out.print("First name: ");
            String firstName = consoleIn.next();
            System.out.print("Last name: ");
            String lastName = consoleIn.next();
            System.out.print("Pather name: ");
            String patherName = consoleIn.next();
            System.out.print("Passport seria: ");
            String seria = consoleIn.next();
            System.out.print("Passport number: ");
            String number = consoleIn.next();

            Clients client = new Clients(firstName, lastName, patherName, seria, number);
            String json = GSON.toJson(client);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.postForEntity(HOST_URL + "/clients/addClient", request, String.class);
//            ResponseEntity<String> responseEntity = restTemplate.postForEntity(HOST_URL + "/clients/addClient", request, String.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void addBook(){

        try {

            System.out.println("Creating book: ");
            System.out.print("Title: ");
            String title = consoleIn.next();
            System.out.print("Pages count: ");
            Integer cnt = consoleIn.nextInt();

            bookTypesIdDialog();
            System.out.print("Select book type ID: ");
            Long id = consoleIn.nextLong();

            BooksPostModel booksPostModel = new BooksPostModel(title, cnt);
            String json = GSON.toJson(booksPostModel);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(HOST_URL + "/books/addBook?bookTypeId=" + id, request, String.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void addBookType(){

        try {
            System.out.println("Creating book type: ");
            System.out.print("Type name: ");
            String typeName = consoleIn.next();
            System.out.print("Count: ");
            Integer cnt = consoleIn.nextInt();
            System.out.print("Fine: ");
            Integer fine = consoleIn.nextInt();
            System.out.print("Days count: ");
            Integer daysCount = consoleIn.nextInt();

            BookTypes bookType = new BookTypes(typeName, cnt, fine, daysCount);
            String json = GSON.toJson(bookType);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(HOST_URL + "/bookTypes/addBookType", request, String.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void clearDatabase(){

        System.out.println("You are going to drop database. Are you sure? (y/n): ");
        if (consoleIn.next().equals("y")){
            try {
                restTemplate.delete(HOST_URL + "/journal/clearDatabase");
                ResponseEntity.ok("Database dropped successfully!");
            }catch (Exception e){
                ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    }

    public static void listDebtors(){

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/journal/debtors", String.class);
        List<Journal> journalList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Journal>>(){}.getType());

        if (journalList.size() < 1){
            System.out.println("There are no debtors yet!");
            return;
        }

        printJournal(journalList);

    }

    public static void findClientsByName(){

        try {

            System.out.print("Enter client's name you want find to: ");
            String name = consoleIn.next();

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/clients/search?name=" + name, String.class);
            List<Clients> clientsList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Clients>>(){}.getType());

            printClients(clientsList);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void findBookByName(){

        try {

            System.out.print("Enter book's title you want find to: ");
            String title = consoleIn.next();

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/books/search?title=" + title, String.class);
            List<Books> booksList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Books>>(){}.getType());

            printBooks(booksList);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void findRecordsByClientFN(){

        try {

            System.out.print("Type name of client that you want find to: ");
            String name = consoleIn.next();

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/journal/findByFirstName?clientName=" + name, String.class);
            List<Journal> journalList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Journal>>() {}.getType());

            printJournal(journalList);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void findBooksByType(){

        try {

            System.out.print("Enter type of books you want find to: ");
            String typeName = consoleIn.next();

            ResponseEntity<String> responseEntity = restTemplate.getForEntity(HOST_URL + "/books/searchByType?typeName=" + typeName, String.class);
            List<Books> booksList = GSON.fromJson(responseEntity.getBody(), new TypeToken<List<Books>>(){}.getType());

            printBooks(booksList);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void editRecord(){

        try {

            journalIdDialog();

            System.out.println("Select record's ID you want edit to: ");
            long id = consoleIn.nextLong();

            System.out.println("Enter new record details:");
            System.out.print("Date beg in format dd/MM/yyyy: ");
            String dateBeg = consoleIn.next();
            System.out.print("Date ret in format dd/MM/yyyy: ");
            String dateRet = consoleIn.next();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            JournalPostModel journalPostModel = new JournalPostModel(simpleDateFormat.parse(dateBeg).getTime(), simpleDateFormat.parse(dateRet).getTime());
            String json = GSON.toJson(journalPostModel);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.put(HOST_URL + "/journal/edit/" + id, request, String.class);

            System.out.println("Edited successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void editBookType(){

        try {

            bookTypesIdDialog();

            System.out.println("Select book type's ID you want edit to: ");
            long id = consoleIn.nextLong();

            System.out.println("Enter book type details:");
            System.out.print("Count: ");
            Integer cnt = consoleIn.nextInt();
            System.out.print("Fine: ");
            Integer fine = consoleIn.nextInt();
            System.out.print("Days count: ");
            Integer daysCount = consoleIn.nextInt();
            System.out.print("Type name: ");
            String typeName = consoleIn.next();

            BookTypes bookType = new BookTypes(typeName, cnt, fine, daysCount);
            String json = GSON.toJson(bookType);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.put(HOST_URL + "/bookTypes/edit/" + id, request, String.class);

            System.out.println("Edited successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void editBook(){

        try {

            booksIdDialog();

            System.out.println("Select book's ID you want edit to: ");
            long id = consoleIn.nextLong();

            System.out.println("Enter book details:");
            System.out.print("Title: ");
            String name = consoleIn.next();
            System.out.print("Pages: ");
            int cnt = consoleIn.nextInt();

            BooksPostModel book = new BooksPostModel(name, cnt);
            String json = GSON.toJson(book);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.put(HOST_URL + "/books/edit/" + id, request, String.class);

            System.out.println("Edited successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void editClient(){

        try {

            clientsIdDialog();

            System.out.print("Select user's ID you want edit to: ");
            long id = consoleIn.nextLong();

            System.out.println("Enter edit details:");
            System.out.print("First name: ");
            String firstName = consoleIn.next();
            System.out.print("Last name: ");
            String lastName = consoleIn.next();
            System.out.print("Pather name: ");
            String patherName = consoleIn.next();
            System.out.print("Passport seria: ");
            String seria = consoleIn.next();
            System.out.print("Passport number: ");
            String number = consoleIn.next();

            Clients client = new Clients(firstName, lastName, patherName, seria, number);
            String json = GSON.toJson(client);

            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);

            restTemplate.put(HOST_URL + "/clients/edit/" + id, request, String.class);

            System.out.println("Edited successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void deleteRecord(){

        try {

            journalIdDialog();

            System.out.println("============================WARNING============================");
            System.out.println("By deleting any record, you also delete client related with it!");
            System.out.println("===============================================================");

            System.out.println("Select record's ID you want delete to: ");
            long id = consoleIn.nextLong();

            restTemplate.delete(HOST_URL + "/journal/delete?id=" + id);

            System.out.println("Record deleted successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void deleteBook(){

        booksIdDialog();

        System.out.print("Select book's ID you want delete to: ");
        long id = consoleIn.nextLong();

        restTemplate.delete(HOST_URL + "/books/" + id);

        System.out.println("Book deleted successfully!");

    }

    public static void deleteBookType(){

        bookTypesIdDialog();

        System.out.print("Select book type's ID you want delete to: ");
        long id = consoleIn.nextLong();

        restTemplate.delete(HOST_URL + "/bookTypes/" + id);

        System.out.println("Book deleted successfully!");

    }

    public static void deleteClientById(){

        try{

            clientsIdDialog();
            System.out.print("Enter client's ID you want delete to: ");
            Long id = consoleIn.nextLong();
            restTemplate.delete(HOST_URL + "/clients/" + id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
