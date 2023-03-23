package com.movie.cinema;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.MongoPropertiesClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.mongodb.MongoClientSettings;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	private final MongoProperties properties;

	//public static final String KEY_STORE_TYPE = "\\filestore.jks";
	public static final String DEFAULT_KEY_STORE_PASSWORD = "changeit";

	public Config(final MongoProperties properties) {
		super();
		this.properties = properties;
	}

	@Bean
	public MongoClientSettings mongoClientSettings() {
		setSslProperties();
		return MongoClientSettings.builder().applyToSslSettings(builder -> builder.enabled(true)).build();

	}

	@Bean
	public MongoPropertiesClientSettingsBuilderCustomizer mongoPropertiesCustomizer(final MongoProperties properties, Environment environment) {
		return new MongoPropertiesClientSettingsBuilderCustomizer(properties,environment);
	}

	/**
	 * This method sets the SSL properties which specify the key store file and its
	 * password.
	 * @throws IOException 
	 *
	 */
	private static void setSslProperties() {
		ClassPathResource classPathResource = new ClassPathResource("filestore.jks");
		try {
			System.setProperty("javax.net.ssl.trustStore", classPathResource.getURL().getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("javax.net.ssl.trustStorePassword", DEFAULT_KEY_STORE_PASSWORD);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}

