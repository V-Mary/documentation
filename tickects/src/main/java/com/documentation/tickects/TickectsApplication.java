package com.documentation.tickects;

import com.documentation.tickects.service.DBLoaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TickectsApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(TickectsApplication.class, args);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TickectsApplication.class, args);
		context.getBean(DBLoaderService.class).dumpCsvToDB("data.csv");
	}

}
