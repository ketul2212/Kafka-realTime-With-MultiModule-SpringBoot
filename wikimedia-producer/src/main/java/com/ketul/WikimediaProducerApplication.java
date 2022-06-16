package com.ketul;

import com.ketul.config.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaProducerApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;

	public static void main(String[] args) {
		SpringApplication.run(WikimediaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaProducerConfig.sendMessage();
	}
}
