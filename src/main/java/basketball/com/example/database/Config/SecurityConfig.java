package basketball.com.example.database.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration // Spring configuration class
@EnableWebSecurity //  Spring Security
public class SecurityConfig {

    // Creates a temporary user account
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Create a test user with credentials
        UserDetails user = User.builder()
                .username("user") // Login username
                .password(passwordEncoder.encode("password")) // Login password (encoded for security)
                .roles("USER") // User's permission level
                .build();

        // Stores this user in memory, but it disappears after restart
        return new InMemoryUserDetailsManager(user);
    }

    // Configures password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Uses BCrypt strong encryption for passwords
        return new BCryptPasswordEncoder();
    }

    // Configures Cross-Origin Resource Sharing (CORS) rules
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from this origin (frontend address)
        config.addAllowedOrigin("http://localhost:63342");

        // Allow all types of headers in requests
        config.addAllowedHeader("*");

        // Allow all HTTP methods (GET, POST, etc.)
        config.addAllowedMethod("*");

        // Allow cookies/credentials
        config.setAllowCredentials(true);

        // Apply these rules to all paths in the application
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    // Main security configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection for simplicity
                .csrf(AbstractHttpConfigurer::disable)

                // Apply our CORS configuration
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Configure access rules for different URLs
                .authorizeHttpRequests(authorize -> authorize
                        // These URLs are open to everyone
                        .requestMatchers("/", "/home", "/login").permitAll()

                        // Swagger/OpenAPI documentation is open to everyone
                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // All other URLs require login
                        .anyRequest().authenticated()
                )

                // Configure the login page
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page URL
                        .defaultSuccessUrl("/swagger-ui.html", true) // Where to go after login
                        .permitAll() // Allow everyone to access the login page
                )

                // Configure logout behavior
                .logout(logout -> logout
                        .permitAll() // Allow everyone to log out
                        .logoutSuccessUrl("/login?logout") // Where to go after logout
                );

        return http.build();
    }
}