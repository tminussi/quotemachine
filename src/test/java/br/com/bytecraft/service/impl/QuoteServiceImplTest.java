package br.com.bytecraft.service.impl;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.model.factory.QuoteFactory;
import br.com.bytecraft.repository.QuoteRepository;
import br.com.bytecraft.service.QuoteService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by thales on 07/09/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuoteServiceImplTest {

    @InjectMocks
    private QuoteServiceImpl quoteService;

    @Mock
    private QuoteRepository quoteRepository;

    @Test
    public void findOneMustCallCorrectMethodOnce() {
        quoteService.findOne(1);
        verify(quoteRepository, atLeastOnce()).findOne(Long.valueOf(1));
    }

    @Test
    public void saveMustCallCorrectMethodOnce() {
        Quote quote = QuoteFactory.createQuote("test", "test");
        quoteService.save(quote);
        verify(quoteRepository, atLeastOnce()).save(quote);
    }

    @Test
    public void findAllMustCallCorrectMethodOnce() {
        quoteService.findAll();
        verify(quoteRepository, atLeastOnce()).findAll();
    }

    @Test
    public void saveAllQuotesMustCallCorrectMethodOnce() {
        Quote quote = QuoteFactory.createQuote("test", "test");
        List<Quote> quotes = Lists.newArrayList(quote);
        quoteService.saveAllQuotes(quotes);
        verify(quoteRepository, atLeastOnce()).save(quotes);
    }

    @Test
    public void getRandomQuoteMustCallCorrectMethodOnce() {
        InOrder inOrder = inOrder(quoteRepository);
        doReturn(502l).when(quoteRepository).count();
        quoteService.getRandomQuote();

        inOrder.verify(quoteRepository, atLeastOnce()).count();
        inOrder.verify(quoteRepository, atLeastOnce()).findOne(any());
    }

    @Test
    public void countMustCallCorrectMethodOnce() {
        quoteService.countQuotes();
        verify(quoteRepository, atLeastOnce()).count();
    }

}