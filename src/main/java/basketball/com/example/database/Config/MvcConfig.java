package basketball.com.example.database.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This configures simple view controllers that map URLs directly to Thymeleaf templates
 * without needing a separate controller class for simple page routing.
 */
@Configuration  // Marks this class as a Spring configuration class
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Configures simple view controllers that map URLs to template names
     * @param registry The ViewControllerRegistry that maintains the view controller mappings
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Home page mapping - both "/home" and root "/" will show the home.html template
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");

        // Maps "/hello" URL to hello.html template
        registry.addViewController("/hello").setViewName("hello");

        // Maps "/login" URL to login.html template
        registry.addViewController("/login").setViewName("login");
    }
}