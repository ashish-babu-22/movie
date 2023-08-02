package com.movieBuff.JPA;

import com.movieBuff.JPA.DAO.MoviebuffDAO;
import com.movieBuff.JPA.Entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MoviebuffDAO moviebuffDAO){
		return runner ->{
			createNewMovie(moviebuffDAO);
		};
	}

	@Transactional
	private void createNewMovie(MoviebuffDAO moviebuffDAO) {

		CustomerDetails cus1 = new CustomerDetails("Pradeep","9898989898");
		CustomerDetails cus2 = new CustomerDetails("Kumar","5252525252");
		MoviesDetails mv1 = new MoviesDetails("Terminator","150 mins","arnold");
		mv1.add(cus1);
		mv1.add(cus2);
		TheatreDetails td1 = new TheatreDetails("PVR","Chennai");
		CustomerDetails cus3 = new CustomerDetails("krishna","95984444");
		CustomerDetails cus4 = new CustomerDetails("parthiv","5545252");
		MoviesDetails mv2 = new MoviesDetails("The boys","150 mins","arnold");
		cus1.add(mv2);
		mv2.add(cus3);
		mv2.add(cus4);
		cus3.add(mv1);
		td1.add(mv1);
		td1.add(mv2);
		OwnerDetails ow1 = new OwnerDetails("Hardik pandya","787878");
		td1.setOwnerDetails(ow1);
		ReviewDetails rv1 = new ReviewDetails("Super hit...block buster");
		ReviewDetails rv2 = new ReviewDetails("one time watchable");
		ReviewDetails rv3 = new ReviewDetails("Ok-ish 3.5/5 ratings");
		mv2.add(rv1);
		mv2.add(rv2);
		mv1.add(rv1);
		mv1.add(rv3);
		System.out.println("saving everthing");
		moviebuffDAO.addNewDetails(mv1);
	//	moviebuffDAO.addNewDetails(mv2);
		System.out.println("Successful!!!!!");

	}

}







