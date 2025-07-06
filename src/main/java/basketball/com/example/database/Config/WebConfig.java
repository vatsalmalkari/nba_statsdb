package basketball.com.example.database.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Marks this as a setup class
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                // Apply to all URLs starting with /api
                .addMapping("/api/**")

                // Allow requests from ANY website (* = wildcard)
                // In production, replace * with your frontend URL
                .allowedOrigins("*")

                // Only allow GET requests
                // Could add "POST", "PUT", etc. if needed
                .allowedMethods("GET");
    }
}