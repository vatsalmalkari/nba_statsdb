package basketball.com.example.database.controller;

import basketball.com.example.database.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this as a REST API controller (returns data, not views)
public class TestController {

    private final PlayerRepository playerRepository;

    // Constructor that automatically gets the PlayerRepository
    public TestController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // GET endpoint that returns total player count
    @GetMapping("/count") // Accessible at http://yourserver.com/count
    public long countPlayers() {
        // Uses the repository's built-in count() method
        return playerRepository.count();
    }
}