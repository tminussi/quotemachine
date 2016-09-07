package br.com.bytecraft.model.factory;

import br.com.bytecraft.model.Quote;

/**
 * Created by thales on 07/09/16.
 */
public class QuoteFactory {

    public static Quote createQuote(String text, String author) {
        return new Quote(text, author);
    }
}
