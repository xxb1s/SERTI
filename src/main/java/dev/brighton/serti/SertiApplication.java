package dev.brighton.serti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SertiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		String host = dotenv.get("DB_HOST");
		String port = dotenv.get("DB_PORT");
		String database = dotenv.get("DB_DATABASE");

		String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);

		Map<String, Object> props = new HashMap<>();
		props.put("spring.application.name", dotenv.get("APP_NAME"));
		props.put("spring.datasource.url", url);
		props.put("spring.datasource.username", dotenv.get("DB_USER"));
		props.put("spring.datasource.password", dotenv.get("DB_PASSWORD"));

		SpringApplication app = new SpringApplication(SertiApplication.class);
		app.setDefaultProperties(props);
		app.run(args);
	}

}
