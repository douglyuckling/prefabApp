package prefabapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import prefabapp.support.PlaceholderConfig;

@Configuration
@PropertySource("classpath:prefabapp/internal.application.properties")
@Import(PlaceholderConfig.class)
public class ApplicationConfig {

    // Application-scoped beans go here...

}
