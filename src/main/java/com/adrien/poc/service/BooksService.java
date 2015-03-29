package com.adrien.poc.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrien.poc.bean.Books;
import com.adrien.poc.repository.BookRepository;

@Service
public class BooksService extends BaseService<Books, BookRepository> {

	@Autowired
	public BooksService(BookRepository repo) {
		super(repo, LoggerFactory.getLogger(BooksService.class));
	}

	/**
	 * This method create a few books
	 */
	public void createBooks() {
		repo.save(new Books(1L, "50 Nuances de grey", "Dorcel", 600));
		repo.save(new Books(2L, "Meurtre sur le nil", "Agatha Christie", 560));
		repo.save(new Books(3L, "Harry Potter à l'école des sorciers", "J.K Roling", 400));
		repo.save(new Books(4L, "50 Nuances plus sombres", "Dorcel", 800));
		repo.save(new Books(5L, "Harry Potter et le prince de sang mélé", "J.K Roling", 653));
		repo.save(new Books(6L, "Harry Potter et la prison d'azkaban", "J.K Roling", 497));
		repo.save(new Books(7L, "L'homme qui voulait être heureux", "Nicolas Gounelle", 187));
		repo.save(new Books(8L, "L'homme qui voulait être heureux", "Nicolas Gounelle", 187));

		for (Books book : repo.findAll()) {
			logger.debug(book.toString());
		}

	}

	/**
	 * This method find a book by his title
	 * 
	 * @param title of the book looked for
	 * @return a book {@link Books}
	 */
	public Books findBookByTitle(String title) {
		logger.debug("Book with title: {}", title);
		return repo.findByTitle(title);
	}

	/**
	 * This method find a list of books by an author
	 * 
	 * @param author of the books looked for
	 * @return a list of books {@link List} {@link Books}
	 */
	public List<Books> findBooksByAuthor(String author) {
		logger.debug("All books for author: {}", author);
		return repo.findByAuthor(author);
	}
}
