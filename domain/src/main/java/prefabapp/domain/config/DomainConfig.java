package prefabapp.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prefabapp.domain.repository.DummyGroceryListItemRepositoryImpl;
import prefabapp.domain.repository.GroceryListItemRepository;

@Configuration
public class DomainConfig {

    @Bean
    public GroceryListItemRepository groceryListItemRepository() {
        return new DummyGroceryListItemRepositoryImpl();
    }

}
