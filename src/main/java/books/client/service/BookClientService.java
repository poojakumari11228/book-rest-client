package books.client.service;

import books.client.dto.Book;
import books.client.dto.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookClientService implements CommandLineRunner {

    private RestTemplate restTemplate;

    @Autowired
    BookClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void callBookApplication() {
        String serverUrl = "http://localhost:8080/api/v1/books";

        // get all
        Books books = restTemplate.getForObject(serverUrl, Books.class);
        System.out.println("----------- get all Books-----------------------");
        System.out.println(books);

        // add book
        System.out.println("----------- Add Book 111 -----------------------");
        restTemplate.postForLocation(serverUrl, new Book("111", "Pooja Kumari", "Software Architecture", 3000.0));

        // add book
        System.out.println("----------- Add Book 222 -----------------------");
        restTemplate.postForLocation(serverUrl, new Book("222", "Pooja Kumari", "DSA", 4000.0));
        // delete 222
        System.out.println("----------- Delete Book 222 -----------------------");
        restTemplate.delete(serverUrl + "/{isbn}", "222");

        // get 111

        System.out.println("----------- Get 111 -----------------------");
        Book book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "111");
        System.out.println(book.getIsbn() + " " + book.getTitle());

        // update 111
        System.out.println("----------- Update 111-----------------------");
        book.setTitle("Algorithm");
        restTemplate.put(serverUrl, book);


    }

    @Override
    public void run(String... args) throws Exception {

    }
}
