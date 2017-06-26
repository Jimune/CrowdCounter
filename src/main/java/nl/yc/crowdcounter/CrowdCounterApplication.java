package nl.yc.crowdcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kastkode.springsandwich.filter"})
public class CrowdCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdCounterApplication.class, args);
	}
}
