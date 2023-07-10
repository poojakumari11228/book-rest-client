package books.client.controller;

import books.client.service.BookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class RestBookClient {

    BookClientService bookClientService;

    @Autowired
    RestBookClient(BookClientService bookClientService) {
        this.bookClientService = bookClientService;
    }

    @GetMapping
    public void callBookService() {
        bookClientService.callBookApplication();
    }
}
