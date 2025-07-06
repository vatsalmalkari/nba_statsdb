package basketball.com.example.database.controller;

import basketball.com.example.database.service.PlayerService;
import basketball.com.example.database.model.Player;
import basketball.com.example.database.repository.PlayerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional; // Import for Optional


@RestController
@RequestMapping("/api/players") // All URLs start with this
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }
    @Operation(summary = "Get all players", security = @SecurityRequirement(name = "JWT"))
    // --- CRUD Operations ---

    // Get all players
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Get a player by ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(ResponseEntity::ok) // If player found, return 200 OK with player
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    // Create a new player
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // Update an existing player

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        try {
            Player updated = playerService.updatePlayer(id, player);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }}

    // Delete a player by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found
        }
    }

    // --- Filter Endpoints (using methods from PlayerRepository) ---

    // Get players by team
    @GetMapping("/by-team") // New, explicit sub-path for filtering by team
    public List<Player> getPlayersByTeam(@RequestParam String team) {
        return playerRepository.findByTeam(team);
    }

    // Get players by position

    @GetMapping("/by-position") // New, explicit sub-path for filtering by position
    public List<Player> getPlayersByPosition(@RequestParam String position) {
        return playerRepository.findByPosition(position);
    }

    // Get players by age

    @GetMapping("/by-age") // New, explicit sub-path for filtering by age
    public List<Player> getPlayersByAge(@RequestParam Integer age) {
        return playerRepository.findByAge(age);
    }

    // get players by points
    @GetMapping("by-points")
    public List<Player> getPlayersByPoints(
            @RequestParam Double points
    )
    {
        return playerRepository.findByPointsPerGame(points);
    }

    //get players by rebounds
    @GetMapping("by-rebounds")
    public List<Player> getPlayersByRebounds(
            @RequestParam Double rebounds
    )
    {
        return playerRepository.findByReboundsPerGame(rebounds);
    }

    @GetMapping("by-steals")
    public List<Player> getPlayersBySteals(
            @RequestParam Double steals)
    {
        return playerRepository.findByStealsPerGame(steals);
    }

    @GetMapping("by-blocks")
    public List<Player> getPlayersByBlocks(
            @RequestParam Double blocks
            )
    {
        return playerRepository.findByBlocksPerGame(blocks);
    }

    @GetMapping("/by-per")
    public List<Player> getPlayersByPerRating(
            @RequestParam Double perRating
    )
    {
        return playerRepository.findByPerRating(perRating);
    }

    @GetMapping("/by-ws")
    public List<Player> getPlayersByWinShares(
            @RequestParam Double winShares
    )
    {
        return playerRepository.findByWinShares(winShares);
    }

    @GetMapping("/by-minutes")
    public List<Player> getPlayersByMinutesPerGame(
            @RequestParam Double minutesPerGame
    )
    {
        return playerRepository.findByMinutesPerGame(minutesPerGame);
    }

    @GetMapping("/by-gamesstarted")
    public List<Player> getPlayersByGamesStarted(
            @RequestParam Integer gamesStarted
    )
    {
        return playerRepository.findByGamesStarted(gamesStarted);
    }

    @GetMapping("/by-games")
    public List<Player> getPlayersByGamesPlayed(
            @RequestParam Integer gamesPlayed
    )
    {
        return playerRepository.findByGamesPlayed(gamesPlayed);
    }


    // Get players by points per-game range - similar for rebounds, assists, steals, blocks,ft, fg, turnovers
    @GetMapping("/filter/pointsRange") // This path was already unique, so it remains
    public List<Player> getPlayersByPointsPerGameRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        return playerRepository.findByPointsPerGameBetween(min, max);
    }

    // get players by assists
    @GetMapping("by-assists")
    public List<Player> getPlayersByAssist(
            @RequestParam Double assist)
            {
        return playerRepository.findByAssistsPerGame(assist);
    }


    @GetMapping("/filter/reboundsRange") // This path was already unique, so it remains
    public List<Player> getPlayersByReboundsPerGameRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        return playerRepository.findByReboundsPerGameBetween(min, max);
    }

    @GetMapping("/filter/assistsRange")
    public List<Player>getPlayersByAssistRange(
            @RequestParam Double min,
            @RequestParam Double max)
    {
        return playerRepository.findByAssistsPerGameBetween(min,max);
    }

    @GetMapping("/filter/stealsRange")
    public List<Player> getPlayersByStealsRange(
            @RequestParam Double min,
            @RequestParam Double max)
    {
        return playerRepository.findByStealsPerGameBetween(min,max);
    }

    @GetMapping("/filter/blocksRange")
    public List<Player> getPlayersByBlocksRange(
            @RequestParam Double min,
            @RequestParam Double max)
    {
        return playerRepository.findByBlocksPerGameBetween(min,max);
    }

    @GetMapping("/by-fgPercentRange")
    public List <Player> getPlayersByFgPercentRange(
            @RequestParam Double min,
            @RequestParam Double max
    )
    {
        return playerRepository.findByFgPercentageBetween(min,max);
    }

    @GetMapping("/by-ftPercentRange")
    public List <Player> getPlayersByFtPercentRange(
            @RequestParam Double min,
            @RequestParam Double max
    )
    {
        return playerRepository.findByFtPercentageBetween(min,max);
    }

    @GetMapping("/by-turnoversRange")
    public List <Player> getPlayersByTurnoversRange(
            @RequestParam Double min,
            @RequestParam Double max
    )
    {
        return playerRepository.findByTurnoversBetween(min,max);
    }


}
