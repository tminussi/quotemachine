package br.com.bytecraft.commons;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.model.factory.QuoteFactory;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by thales on 07/09/16.
 */
public class CsvFileReader {

    private static final int TEXT_INDEX = 0;
    private static final int AUTHOR_INDEX = 1;

    public static List<Quote> readCsvFile(File file) throws IOException {


        List<Quote> quotes = new ArrayList<>();

        Iterable<CSVRecord> records = CSVFormat.newFormat(';').withFirstRecordAsHeader().parse(new FileReader(file.getPath()));

        for (CSVRecord record : records) {
            try {
                Quote quote = QuoteFactory.createQuote(record.get(0), record.get(1));
                quotes.add(quote);
            } catch (Exception e) {
                System.out.println(record);
            }
        }
        return quotes;

    }
}
