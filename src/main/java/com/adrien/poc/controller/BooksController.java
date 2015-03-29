package com.adrien.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrien.poc.bean.Books;
import com.adrien.poc.service.BooksService;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	private final BooksService booksService;

	@Autowired
	BooksController(BooksService booksService) {
		this.booksService = booksService;
	}

	@RequestMapping(value = "/createBook/{title}/{author}/{nbPages}")
	Books createBook(@PathVariable String title, @PathVariable String author, @PathVariable int nbPages) throws Exception {
		return booksService.createBook(new Books(0L, title, author, nbPages));
	}

	@RequestMapping("/createBooks")
	List<Books> createBooks() throws Exception {
		return booksService.createBooks();
	}

	@RequestMapping("/deleteBooks")
	void deleteBooks() {
		booksService.deleteAll();
	}

	@RequestMapping(value = "deleteBook/{id}")
	void deleteBook(@PathVariable Long id) {
		booksService.deleteOne(id);
	}

	@RequestMapping(value = "/findBook/{id}")
	Books findBook(@PathVariable Long id) {
		return booksService.findOne(id);
	}

	@RequestMapping(value = "findBook/title/{title}")
	private Books findBookByTitle(@PathVariable String title) {
		return booksService.findBookByTitle(title);
	}

	@RequestMapping(value = "findBook/author/{author}")
	private List<Books> findBookByAuthor(@PathVariable String author) {
		return booksService.findBooksByAuthor(author);
	}

	@RequestMapping("/findBooks")
	List<Books> findBooks() {
		return booksService.findAll();
	}

	@RequestMapping(value = "/updateBook/{id}/{title}")
	Books updateBook(@PathVariable Long id, @PathVariable String title) {
		Books book = booksService.findOne(id);
		book.setTitle(title);

		return booksService.save(book);
	}

}
