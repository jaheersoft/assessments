package com.csw.converters;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConvertersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConvertersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File jsonFile = new File(args[0]);
		File xmlFile = new File(args[1]);
		ConverterFactory.createXMLJSONConverter().convertJSONtoXML(jsonFile, xmlFile);
	}

}
