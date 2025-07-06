package basketball.com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // Handles web page requests (returns HTML templates)
public class WebController {

    // Maps GET requests for "/login" to login.html template
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Uses src/main/resources/templates/login.html
    }
}