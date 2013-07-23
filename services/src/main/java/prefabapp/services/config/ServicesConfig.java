package prefabapp.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import prefabapp.domain.config.DomainConfig;
import prefabapp.services.GroceryListService;
import prefabapp.services.GroceryListServiceImpl;

@Configuration
@Import(DomainConfig.class)
public class ServicesConfig {

    @Bean
    public GroceryListService groceryListService() {
        return new GroceryListServiceImpl();
    }

}
