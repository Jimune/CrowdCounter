package nl.yc.crowdcounter;

import nl.yc.crowdcounter.filter.LoginFilter;
import nl.yc.crowdcounter.filter.PermissionFilter;
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
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }

    @Bean
    public PermissionFilter permissionFilter() {
        return new PermissionFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginFilter());
        registry.addInterceptor(permissionFilter());
    }

}
