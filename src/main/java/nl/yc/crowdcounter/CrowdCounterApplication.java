package nl.yc.crowdcounter;

import nl.yc.crowdcounter.filter.CrowdCounterSessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpSessionListener;

@SpringBootApplication
public class CrowdCounterApplication {

	public static void main(String[] args) {
        SpringApplication.run(CrowdCounterApplication.class, args);
    }

    @Bean
    public HttpSessionListener crowdCounterSessionListener() {
        return new CrowdCounterSessionListener();
    }
}
