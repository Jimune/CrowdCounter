package nl.yc.crowdcounter;

import nl.yc.crowdcounter.filter.SessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jim on 6/26/17.
 */
@Configuration
public class Configurator extends WebMvcConfigurerAdapter {

    @Bean
    public SessionFilter permissionFilter() {
        return new SessionFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginFilter());
        registry.addInterceptor(permissionFilter());
    }

}
