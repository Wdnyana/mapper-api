package com.crud.mapper;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.crud.mapper-api"})
public class MapperApplication {
	@Value("${application.timezone:UTC}")
	private String timeZone;

	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class, args);
	}

	@PostConstruct
	public void executeAfterMain() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}
}
