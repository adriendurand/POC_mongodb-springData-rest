package com.adrien.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrien.poc.bean.Books;
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

		logger.debug("*****************************************************************");

		bookService.deleteAll();
		bookService.createBooks();
		Books book = bookService.findBookByTitle("Meurtre sur le nil");
		logger.debug("Book: {}", book.toString());

		for (Books abook : bookService.findBooksByAuthor("Dorcel")) {
			logger.debug(abook.toString());
		}

		book = bookService.findOne(2L);
		logger.debug("Book: " + book.toString());
		book.setTitle("Mort sur le nil");
		book = bookService.save(book);
		logger.debug("My Book updated: " + book.toString());

		Books book2 = bookService.findOne(8L);
		bookService.delete(book2);

		for (Books item : bookService.findAll()) {
			logger.debug(item.toString());
		}

		logger.debug("*****************************************************************");
	}
}
