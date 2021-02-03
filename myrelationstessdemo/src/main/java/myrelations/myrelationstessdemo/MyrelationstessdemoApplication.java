package myrelations.myrelationstessdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyrelationstessdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyrelationstessdemoApplication.class, args);
	}

}
