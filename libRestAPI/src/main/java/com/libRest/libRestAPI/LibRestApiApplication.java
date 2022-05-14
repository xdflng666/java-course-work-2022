package com.libRest.libRestAPI;

import com.libRest.libRestAPI.repository.BookTypesRepository;
import com.libRest.libRestAPI.repository.BooksRepository;
import com.libRest.libRestAPI.repository.ClientsRepository;
import com.libRest.libRestAPI.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LibRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibRestApiApplication.class, args);
	}

//	@Autowired
//	private JournalRepository journalRepository;
//
//	@Autowired
//	private ClientsRepository clientsRepository;
//
//	@Autowired
//	private BooksRepository booksRepository;
//
//	@Autowired
//	private BookTypesRepository bookTypes;
//
//
//	@Bean
//	public CommandLineRunner test(){
//		return args -> {
//
//		};
//	}


}
