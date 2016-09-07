package br.com.bytecraft.service.impl;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.repository.QuoteRepository;
import br.com.bytecraft.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote findOne(Long id) {
        return repository.findOne(1l);
    }

    @Override
    public void save(Quote quote) {
        repository.save(quote);
    }

    @Override
    public Iterable<Quote> findAll() {
        return repository.findAll();
    }

}
