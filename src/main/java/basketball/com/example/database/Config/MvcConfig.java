package basketball.com.example.database.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 
@Configuration  
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Configures simple view controllers that map URLs to template names
     * @param registry The ViewControllerRegistry that maintains the view controller mappings
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
}