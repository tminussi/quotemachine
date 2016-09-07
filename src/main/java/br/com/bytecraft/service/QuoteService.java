package br.com.bytecraft.service;

import br.com.bytecraft.model.Quote;

public interface QuoteService {

    Quote findOne(Long id);

    void save(Quote quote);

    Iterable<Quote> findAll();
}
