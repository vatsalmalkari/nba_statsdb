package basketball.com.example.database.service;
import basketball.com.example.database.exception.PlayerNotFoundException;
import basketball.com.example.database.model.Player;
import basketball.com.example.database.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Basic Fetch Methods
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    public List<Player> getPlayersByAge(Integer age) {
        return playerRepository.findByAge(age);
    }

    public List<Player> getPlayersByFgPercentage(Double fgPercentage) {
        return playerRepository.findByFgPercentage(fgPercentage);
    }

    public List<Player> getPlayersByFtPercentage(Double ftPercentage) {
        return playerRepository.findByFtPercentage(ftPercentage);
    }

    public List<Player> getPlayersByTurnovers(Double turnovers) {
        return playerRepository.findByTurnovers(turnovers);
    }

    public List<Player> getPlayersByAssist(Double assists) {
        return playerRepository.findByAssistsPerGame(assists);
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

    public List<Player> getPlayersByMinutesPerGame(Double mpg) {
        return playerRepository.findByMinutesPerGame(mpg);
    }

    // Range Queries
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

    // CRUD
    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
    public List<Player> getPlayersByName(String name) {
        return playerRepository.findByPlayerName(name);
    }

    public List<Player> getPlayersByTeam(String team) {
        return playerRepository.findByTeam(team);
    }

    

    public Player updatePlayer(Integer id, Player updatedPlayer) {
        Player existing = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));

        existing.setPlayerName(updatedPlayer.getPlayerName());
        existing.setTeam(updatedPlayer.getTeam());
        existing.setPosition(updatedPlayer.getPosition());
        existing.setAge(updatedPlayer.getAge());
        existing.setGamesPlayed(updatedPlayer.getGamesPlayed());
        existing.setGamesStarted(updatedPlayer.getGamesStarted());
        existing.setPointsPerGame(updatedPlayer.getPointsPerGame());
        existing.setReboundsPerGame(updatedPlayer.getReboundsPerGame());
        existing.setAssistsPerGame(updatedPlayer.getAssistsPerGame());
        existing.setStealsPerGame(updatedPlayer.getStealsPerGame());
        existing.setBlocksPerGame(updatedPlayer.getBlocksPerGame());
        existing.setFgPercentage(updatedPlayer.getFgPercentage());
        existing.setFtPercentage(updatedPlayer.getFtPercentage());
        existing.setTurnovers(updatedPlayer.getTurnovers());
        existing.setMinutesPerGame(updatedPlayer.getMinutesPerGame());
        existing.setPerRating(updatedPlayer.getPerRating());
        existing.setWinShares(updatedPlayer.getWinShares());
        existing.setThreePointPercentage(updatedPlayer.getThreePointPercentage());
        existing.setEffectiveFieldGoalPercentage(updatedPlayer.getEffectiveFieldGoalPercentage());
        existing.setTrueShootingPercentage(updatedPlayer.getTrueShootingPercentage());
        existing.setUsageRate(updatedPlayer.getUsageRate());
        existing.setOffensiveRating(updatedPlayer.getOffensiveRating());
        existing.setDefensiveRating(updatedPlayer.getDefensiveRating());
        return playerRepository.save(existing);
    }
    public boolean deletePlayer(Integer id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
