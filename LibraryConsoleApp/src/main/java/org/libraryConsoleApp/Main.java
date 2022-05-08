package org.libraryConsoleApp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import static org.libraryConsoleApp.rest.RequestSender.*;

public class Main {

//    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

////        DATEEEE
//        Long minDate = 1009832400000L;
//        Date test = new Date(minDate);
//        System.out.println(test.getTime());

//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Enter str: ");
//        String str = in.nextLine();
//        System.out.println("Str is " + str);
//
//        System.out.println("Enter int: ");
//        int num = in.nextInt();
//        System.out.println("Your num " + num);

//        addBookType();
//        getClients();
//        getBookTypes();
//        getBooks();
//        listJournal();
//        findClientsByName();
//        findBookByName();


//        RestTemplate restTemplate = new RestTemplate();
//
//        Clients client = new Clients("Ivan", "Ivanov", "Ivanovich", "2343", "534823");
//
//        String json = GSON.toJson(client);
//
//        Clients resp = GSON.fromJson(json, Clients.class);


        getClients();

    }
}