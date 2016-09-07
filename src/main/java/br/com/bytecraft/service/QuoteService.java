package br.com.bytecraft.service;

import br.com.bytecraft.model.Quote;

import java.util.List;

public interface QuoteService {

    Quote findOne(Integer id);

    void save(Quote quote);

    Iterable<Quote> findAll();

    void saveAllQuotes(List<Quote> quotes);

    Quote getRandomQuote();

    Integer countQuotes();
}
