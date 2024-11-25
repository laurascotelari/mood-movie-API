package com.laurascot.moviesAPI;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.laurascot.moviesAPI.repositorys.MovieRepository;

@SpringBootApplication
public class MoviesApiApplication {
	private static final Logger log = Logger.getLogger(MoviesApiApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(MoviesApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MovieRepository repository) {
		return (args) -> {

			log.info("Movies found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(movie -> {
				log.info(movie.getName());
			});
		};
	}

}
