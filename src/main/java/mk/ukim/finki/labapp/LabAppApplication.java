package mk.ukim.finki.labapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LabAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(LabAppApplication.class, args);
	}

}
