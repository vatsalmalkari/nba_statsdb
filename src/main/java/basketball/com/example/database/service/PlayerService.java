package basketball.com.example.database.service;

import basketball.com.example.database.exception.PlayerNotFoundException;
import basketball.com.example.database.model.Player;
import basketball.com.example.database.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;
//Controller → Service → Repository → Database
@Service
public class PlayerService {
    // Uses PlayerRepository for database operations
    private final PlayerRepository playerRepository;
    // Constructor injection
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Get all players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Get by team
    public List<Player> getPlayersByTeam(String team) {
        return playerRepository.findByTeam(team);
    }

    // Get by position
    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    // Get by age
    public List<Player> getPlayersByAge(Integer age) {
        return playerRepository.findByAge(age);
    }



    public List<Player> getPlayersByAssist(Double assist) {
        return playerRepository.findByAssistsPerGame(assist);
    }

    public List<Player> getPlayersBySteals(Double steals) {
        return playerRepository.findByStealsPerGame(steals);
    }

    public List<Player> getPlayersByRebounds(Double rebounds) {
        return playerRepository.findByReboundsPerGame(rebounds);
    }

    public List<Player> getPlayersByPoints(Double points) {
        return playerRepository.findByPointsPerGame(points);
    }

    public List<Player> getPlayersByGamesStarted(Integer gamesStarted) {
        return playerRepository.findByGamesStarted(gamesStarted);
    }

    public List<Player> getPlayersByGamesPlayed(Integer gamesPlayed) {
        return playerRepository.findByGamesPlayed(gamesPlayed);
    }

    public List<Player> getPlayersByBlocks(Double blocks) {
        return playerRepository.findByBlocksPerGame(blocks);
    }
    public List<Player> getPlayersByPerRating(Double perRating) {
        return playerRepository.findByPerRating(perRating);
    }
    public List<Player> getPlayersByWinShares(Double winShares) {
        return playerRepository.findByWinShares(winShares);
    }

    public List<Player> getPlayersByMinutesPerGame(Double minutesPerGame) {
        return playerRepository.findByMinutesPerGame(minutesPerGame);
    }

    public List<Player> getPlayersByPointsRange(Double min, Double max) {
        return playerRepository.findByPointsPerGameBetween(min, max);
    }

    public List<Player> getPlayersByReboundsRange(Double min, Double max) {
        return playerRepository.findByReboundsPerGameBetween(min, max);
    }

    public List<Player> getPlayersByAssistRange(Double min, Double max) {
        return playerRepository.findByAssistsPerGameBetween(min, max);
    }

    public List<Player> getPlayersByStealsRange(Double min, Double max) {
        return playerRepository.findByStealsPerGameBetween(min, max);
    }

    public List<Player> getPlayersByBlocksRange(Double min, Double max) {
        return playerRepository.findByBlocksPerGameBetween(min, max);
    }

    public List<Player> getPlayersByFgPercentRange(Double min, Double max) {
        return playerRepository.findByFgPercentageBetween(min, max);
    }

    public List<Player> getPlayersByFtPercentRange(Double min, Double max) {
        return playerRepository.findByFtPercentageBetween(min, max);
    }

    public List<Player> getPlayersByTurnoversRange(Double min, Double max) {
        return playerRepository.findByTurnoversBetween(min, max);
    }

    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + id));
    }


    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
    // 1. Find existing player
    // 2. Update all fields
    public Player updatePlayer(Integer id, Player updatedPlayer) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found with id " + id));

        // Update fields
        existingPlayer.setPlayerName(updatedPlayer.setPlayerName);
        existingPlayer.setTeam(updatedPlayer.getTeam());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        existingPlayer.setAge(updatedPlayer.getAge());
        existingPlayer.setGamesPlayed(updatedPlayer.getGames_played());
        existingPlayer.setPointsPerGame(updatedPlayer.getPoints_per_game());
        existingPlayer.setReboundsPerGame(updatedPlayer.getRebounds_per_game());
        existingPlayer.setAssistsPerGame(updatedPlayer.getAssists_per_game());
        existingPlayer.setStealsPerGame(updatedPlayer.getSteals_per_game());
        existingPlayer.setBlocksPerGame(updatedPlayer.getBlocks_per_game());
        existingPlayer.setWinShares(updatedPlayer.getWin_shares());
        existingPlayer.setMinutesPerGame(updatedPlayer.getMinutes_per_game());
        existingPlayer.setPerRating(updatedPlayer.getPer_rating());
        existingPlayer.setGamesStarted(updatedPlayer.getGames_started());
        existingPlayer.setFgPercentage(updatedPlayer.getFg_percentage());
        existingPlayer.setFtPercentage(updatedPlayer.getFt_percentage());
        existingPlayer.setTurnovers(updatedPlayer.getTurnovers());

        return playerRepository.save(existingPlayer);
    }


}
