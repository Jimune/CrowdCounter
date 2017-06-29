package nl.yc.crowdcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdCounterApplication {

	public static void main(String[] args) {
        SpringApplication.run(CrowdCounterApplication.class, args);
        /*long start = System.nanoTime();

        Set<String> macs = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            String mac = Util.getRandomMac();
        }
        long end = System.nanoTime();
        System.out.println((end - start));
        */
    }
}
