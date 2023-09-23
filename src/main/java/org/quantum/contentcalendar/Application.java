package org.quantum.contentcalendar;

import java.time.LocalDateTime;

import org.quantum.contentcalendar.model.Content;
import org.quantum.contentcalendar.model.Status;
import org.quantum.contentcalendar.model.Type;
import org.quantum.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner loadData(ContentRepository repository) {
	return args -> {
	    repository.save(new Content(null, "Spring data jdbc", "Spring data jdbc course", Status.IN_PROGRESS,
		    Type.COURSE, LocalDateTime.now(), null, null));

	};
    }

}
