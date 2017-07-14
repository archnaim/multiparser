package com.multiparser.multiparsertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@AutoConfigurationPackage
@Import(SpringConfiguration.class)
public class MultiparserTestApplication {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MultiparserTestApplication.class, args);
	}
}
