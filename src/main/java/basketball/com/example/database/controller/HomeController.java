package basketball.com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Marks this as a web controller that returns view templates
public class HomeController {

    // Handles GET requests to "/home" URL
    @GetMapping("/home")
    public String home() {
        // Returns the name of the Thymeleaf template to display
        // Spring will look for: src/main/resources/templates/home.html
        return "home";
    }
}