package br.com.bytecraft;

import br.com.bytecraft.model.Quote;
import br.com.bytecraft.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuoteMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteMachineApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuoteService service) {
		return (args) -> {
			Quote quote = new Quote();
			quote.setText("Lorem Ipsum is the best bla bla bla generator ever");
			quote.setAuthor("Thales");

			service.save(quote);
		};
	}
}
