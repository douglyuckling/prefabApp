package prefabapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import prefabapp.support.PlaceholderConfig;

@Configuration
@Import(PlaceholderConfig.class)
@EnableWebMvc
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {

    // Servlet configuration and servlet-scoped beans go here...

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
    }

}
