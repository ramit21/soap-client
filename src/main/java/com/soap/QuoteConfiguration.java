package com.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class QuoteConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this context path must match the package specified in build.xml
		marshaller.setContextPath("com.webservice");
		return marshaller;
	}

	@Bean
	public QuoteClient quoteClient(Jaxb2Marshaller marshaller) {
		QuoteClient client = new QuoteClient();
		client.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
