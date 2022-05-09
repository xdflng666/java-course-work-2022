package org.libraryConsoleApp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import static org.libraryConsoleApp.rest.RequestSender.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

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
                    case "find book by name"   -> findBookByName();
                    case "delete client"       -> deleteClientById();
                    case "edit client"         -> editClient();
                    case "edit book"           -> editBook();
                    case "edit book type"      -> editBookType();
                    case "edit record"         -> editRecord();
                    case "exit" -> System.exit(0);
                    default -> System.out.println("Unknown command!\nType \"help\" to see commands' list");
                }


            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

}