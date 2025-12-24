package basketball.com.example.database.Config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration  // Tells Spring this is a configuration class
public class OpenApiConfig {

    /**
     * Creates and configures the OpenAPI/Swagger documentation settings
     * @return The configured OpenAPI object that Swagger will use
     */
    @Bean 
    public OpenAPI customOpenAPI() {
        
        return new OpenAPI()
                .info(new Info()
                        .title("Basketball API")       
                        .version("1.0")              
                        .description("Player database API for basketball statistics."));  
    }
}