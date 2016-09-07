package br.com.bytecraft.service.impl;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.repository.QuoteRepository;
import br.com.bytecraft.service.QuoteService;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote findOne(Integer id) {
        return repository.findOne(Long.valueOf(id));
    }

    @Override
    public void save(Quote quote) {
        repository.save(quote);
    }

    @Override
    public Iterable<Quote> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveAllQuotes(List<Quote> quotes) {
        repository.save(quotes);
    }

    @Override
    public Quote getRandomQuote() {
        return repository.findOne(Long.valueOf(getARandomWithinRange()));
    }

    private int getARandomWithinRange() {
        return new Random().nextInt(countQuotes() + 1) + 1;
    }

    @Override
    public Integer countQuotes() {
        return Math.toIntExact(repository.count());
    }


}
