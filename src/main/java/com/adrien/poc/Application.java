package com.adrien.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrien.poc.service.BooksService;

/**
 * Main application
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BooksService bookService;

	private final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.run(args);
	}

	public void run(String... args) throws Exception {
		logger.debug("Main");
	}
}
