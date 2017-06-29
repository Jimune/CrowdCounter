package nl.yc.crowdcounter;

import nl.yc.crowdcounter.util.Util;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CrowdCounterApplication {

	public static void main(String[] args) {
        //SpringApplication.run(CrowdCounterApplication.class, args);
        long start = System.nanoTime();

        Set<String> macs = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            String mac = Util.getRandomMac();
        }
        long end = System.nanoTime();
        System.out.println((end - start));
    }
}
