package br.com.bytecraft.controller;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class QuoteController {

    @Autowired
    private QuoteService service;

    @RequestMapping(value = "quotes", method = RequestMethod.GET)
    public Quote findOne() {
        return service.getRandomQuote();
    }

}
