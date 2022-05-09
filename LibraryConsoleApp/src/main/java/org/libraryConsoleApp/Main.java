package org.libraryConsoleApp;

import java.util.Scanner;

import static org.libraryConsoleApp.rest.RequestSender.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true){
            try{

                System.out.print("\n>> ");
                String command = input.nextLine();

                switch (command) {
                    case "journal"             -> listJournal();
                    case "clients"             -> getClients();
                    case "books"               -> getBooks();
                    case "types"               -> getBookTypes();
                    case "add record"          -> addRecord();
                    case "add client"          -> addClient();
                    case "add book"            -> addBook();
                    case "add type"            -> addBookType();
                    case "show debtors"        -> listDebtors();
                    case "find client by name" -> findClientsByName();
                    case "find book by title"   -> findBookByName();
                    case "find books by type"  -> findBooksByType();
                    case "find recs by fn"     -> findRecordsByClientFN();
                    case "edit client"         -> editClient();
                    case "edit book"           -> editBook();
                    case "edit book type"      -> editBookType();
                    case "edit record"         -> editRecord();
                    case "delete record"       -> deleteRecord();
                    case "delete book"         -> deleteBook();
                    case "delete type"         -> deleteBookType();
                    case "help"                -> help();
                    case "exit" -> System.exit(0);
                    default -> System.out.println("Unknown command!\nType \"help\" to see commands' list");
                }


            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public static void help(){
        System.out.println("===========================COMMANDS LIST===========================");
        System.out.println("journal - list journal");
        System.out.println("clients - list clients");
        System.out.println("books - list books");
        System.out.println("types - list books' types");
        System.out.println("add record - add record to journal");
        System.out.println("add client - add new client");
        System.out.println("add book - add new book");
        System.out.println("add type - add new book type");
        System.out.println("show debtors - list all debtors");
        System.out.println("find client by name - find clients by his first name");
        System.out.println("find book by title - find book by it's title");
        System.out.println("find books by type - find books by genre ");
        System.out.println("find recs by fn - find all records by client's first name");
        System.out.println("edit record - edit recording in journal by ID");
        System.out.println("edit client - edit client by ID");
        System.out.println("edit book - edit book by ID");
        System.out.println("edit book type - edit book type by ID");
        System.out.println("delete record - delete record by ID");
        System.out.println("delete book - delete book by ID");
        System.out.println("delete book type - delete book type by ID");
        System.out.println("exit - exit program");
        System.out.println("===================================================================");
    }

}