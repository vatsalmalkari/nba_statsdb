package basketball.com.example.database.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configures the Swagger/OpenAPI documentation
 * Swagger will automatically generate interactive API documentation.
 */
@Configuration  // Tells Spring this is a configuration class
public class OpenApiConfig {

    /**
     * Creates and configures the OpenAPI/Swagger documentation settings
     * @return The configured OpenAPI object that Swagger will use
     */
    @Bean  // Tells Spring to use this object when Swagger documentation is needed
    public OpenAPI customOpenAPI() {
        // Build and return the OpenAPI configuration
        return new OpenAPI()
                // Set the API information that appears in the documentation
                .info(new Info()
                        .title("Basketball API")       // The title shown at the top of the docs
                        .version("1.0")               // Version number of our API
                        .description("Player database API for basketball statistics."));  // What our API does
    }
}