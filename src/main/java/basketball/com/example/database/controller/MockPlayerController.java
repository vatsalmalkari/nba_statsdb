package basketball.com.example.database.controller;

import basketball.com.example.database.model.Player;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/mock/players") // Different path
public class MockPlayerController {

    @GetMapping
    public List<Player> getAllMockPlayers() {
        return Arrays.asList(
                new Player(1, "LeBron James", "LAL", "SF", 40, 70, 24.4, 7.8, 8.2, 1.0, 0.6, 7.7, 34.9, 22.7, 70, 0.513, 0.782, 3.7),
                new Player(2, "Stephen Curry", "GSW", "PG", 36, 65, 27.3, 5.1, 5.4, 1.3, 0.3, 8.2, 33.5, 24.1, 65, 0.472, 0.918, 3.1)
        );
    }

    @GetMapping("/{id}")
    public Player getMockPlayerById(@PathVariable Integer id) {
        if (id == 1) {
            return new Player(1, "LeBron James", "LAL", "SF", 40, 70, 24.4, 7.8, 8.2, 1.0, 0.6, 7.7, 34.9, 22.7, 70, 0.513, 0.782, 3.7);
        } else {
            return new Player(2, "Stephen Curry", "GSW", "PG", 36, 65, 27.3, 5.1, 5.4, 1.3, 0.3, 8.2, 33.5, 24.1, 65, 0.472, 0.918, 3.1);
        }
    }
}
