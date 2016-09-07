package br.com.bytecraft;

import br.com.bytecraft.commons.CsvFileReader;
import br.com.bytecraft.model.Quote;
import br.com.bytecraft.service.QuoteService;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class QuoteMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteMachineApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuoteService service) {
		return (args) -> {
			ClassLoader classLoader = this.getClass().getClassLoader();
			InputStream	inputStream = classLoader.getResourceAsStream("litemind-quotes.csv");
			File file = new File("quotes.csv");
			OutputStream outputStream = new FileOutputStream(file);
			IOUtils.copy(inputStream, outputStream);
			outputStream.close();
			service.saveAllQuotes(CsvFileReader.readCsvFile(file));
		};
	}
}
