package com.upgrad.bookmyticket;

import com.upgrad.bookmyticket.config.ApiConfiguration;
import com.upgrad.bookmyticket.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApiConfiguration.class, WebConfiguration.class})
public class BookmyticketApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookmyticketApplication.class, args);
	}

}
