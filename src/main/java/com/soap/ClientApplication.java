package com.soap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webservice.GetQuoteResponse;


@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(final QuoteClient quoteClient) {

		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				String ticker = "MSFT";
				GetQuoteResponse response = quoteClient.getQuote(ticker);
				System.err.println(response.getGetQuoteResult());
			}
		};
	}
}
