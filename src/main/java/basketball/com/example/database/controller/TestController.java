package basketball.com.example.database.controller;

import basketball.com.example.database.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final PlayerRepository playerRepository;

    public TestController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/count") 
    public long countPlayers() {
        return playerRepository.count();
    }
}