package br.com.bytecraft;

import br.com.bytecraft.commons.CsvFileReader;
import br.com.bytecraft.model.Quote;
import br.com.bytecraft.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class QuoteMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteMachineApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuoteService service) {
		return (args) -> {
			File file = new ClassPathResource("litemind-quotes.csv").getFile();
			List<Quote> quotes = CsvFileReader.readCsvFile(file);
			service.saveAllQuotes(quotes);
		};
	}
}
