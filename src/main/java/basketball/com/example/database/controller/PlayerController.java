package basketball.com.example.database.controller;
import basketball.com.example.database.model.Player;
import basketball.com.example.database.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // CRUD
    @Operation(summary = "Get all players")
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @Operation(summary = "Get a player by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(playerService.getPlayerById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new player")
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(player));
    }

    @Operation(summary = "Update an existing player")
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable Integer id,
            @RequestBody Player player) {
        try {
            return ResponseEntity.ok(playerService.updatePlayer(id, player));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a player by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        boolean deleted = playerService.deletePlayer(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/team")
    public ResponseEntity<List<Player>> getByTeam(@RequestParam String team) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(team));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Player>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(playerService.getPlayersByName(name));
    }

    @GetMapping("/position")
    public ResponseEntity<List<Player>> getByPosition(@RequestParam String position) {
        return ResponseEntity.ok(playerService.getPlayersByPosition(position));
    }

    @GetMapping("/age")
    public ResponseEntity<List<Player>> getByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(playerService.getPlayersByAge(age));
    }

    @GetMapping("/points")
    public ResponseEntity<List<Player>> getByPoints(@RequestParam Double points) {
        return ResponseEntity.ok(playerService.getPlayersByPoints(points));
    }

    @GetMapping("/rebounds")
    public ResponseEntity<List<Player>> getByRebounds(@RequestParam Double rebounds) {
        return ResponseEntity.ok(playerService.getPlayersByRebounds(rebounds));
    }

    @GetMapping("/assists")
    public ResponseEntity<List<Player>> getByAssists(@RequestParam Double assists) {
        return ResponseEntity.ok(playerService.getPlayersByAssist(assists));
    }

    @GetMapping("/steals")
    public ResponseEntity<List<Player>> getBySteals(@RequestParam Double steals) {
        return ResponseEntity.ok(playerService.getPlayersBySteals(steals));
    }

    @GetMapping("/blocks")
    public ResponseEntity<List<Player>> getByBlocks(@RequestParam Double blocks) {
        return ResponseEntity.ok(playerService.getPlayersByBlocks(blocks));
    }

    @GetMapping("/fg")
    public ResponseEntity<List<Player>> getByFg(@RequestParam Double fg) {
        return ResponseEntity.ok(playerService.getPlayersByFgPercentage(fg));
    }

    @GetMapping("/ft")
    public ResponseEntity<List<Player>> getByFt(@RequestParam Double ft) {
        return ResponseEntity.ok(playerService.getPlayersByFtPercentage(ft));
    }

    @GetMapping("/turnovers")
    public ResponseEntity<List<Player>> getByTurnovers(@RequestParam Double turnovers) {
        return ResponseEntity.ok(playerService.getPlayersByTurnovers(turnovers));
    }

    @GetMapping("/range/points")
    public ResponseEntity<List<Player>> getByPointsRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByPointsRange(min, max));
    }

    @GetMapping("/range/rebounds")
    public ResponseEntity<List<Player>> getByReboundsRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByReboundsRange(min, max));
    }

    @GetMapping("/range/assists")
    public ResponseEntity<List<Player>> getByAssistsRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByAssistRange(min, max));
    }

    @GetMapping("/range/steals")
    public ResponseEntity<List<Player>> getByStealsRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByStealsRange(min, max));
    }

    @GetMapping("/range/blocks")
    public ResponseEntity<List<Player>> getByBlocksRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByBlocksRange(min, max));
    }

    @GetMapping("/range/fg")
    public ResponseEntity<List<Player>> getByFgRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByFgPercentRange(min, max));
    }

    @GetMapping("/range/ft")
    public ResponseEntity<List<Player>> getByFtRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByFtPercentRange(min, max));
    }

    @GetMapping("/range/turnovers")
    public ResponseEntity<List<Player>> getByTurnoversRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(playerService.getPlayersByTurnoversRange(min, max));
    }
}
