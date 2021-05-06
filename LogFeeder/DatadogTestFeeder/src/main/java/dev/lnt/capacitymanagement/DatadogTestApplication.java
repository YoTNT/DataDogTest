package dev.lnt.capacitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.lnt")
public class DatadogTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatadogTestApplication.class, args);
	}

}
