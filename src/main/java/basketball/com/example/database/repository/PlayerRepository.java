package basketball.com.example.database.repository;
import basketball.com.example.database.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //spring creates implementation at run time
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // exact value methods - return players who averaged the exact value provided or are in that age, position, team
    List<Player> findByTeam(String team);
    List<Player> findByPosition(String position);
    List<Player> findByAge(Integer age);
    List<Player> findByPointsPerGame(Double pointsPerGame);
    List<Player> findByReboundsPerGame(Double reboundsPerGame);
    List<Player> findByAssistsPerGame(Double assistsPerGame);
    List<Player> findByStealsPerGame(Double stealsPerGame);
    List<Player> findByBlocksPerGame(Double blocksPerGame);
    List<Player> findByWinShares(Double winShares);
    List<Player> findByMinutesPerGame(Double minutesPerGame);
    List<Player> findByPerRating(Double perRating);
    List<Player> findByGamesStarted(Integer gamesStarted);
    List<Player> findByGamesPlayed(Integer gamesPlayed);


    // range of values methods - returns players who averaged between min and max
    List<Player> findByPointsPerGameBetween(Double min, Double max); // Changed
    List<Player> findByReboundsPerGameBetween(Double min, Double max); // Changed

    List<Player> findByAssistsPerGameBetween(Double min, Double max);

    List<Player> findByStealsPerGameBetween(Double min, Double max);
    List<Player> findByBlocksPerGameBetween(Double min, Double max);

    List<Player> findByFgPercentageBetween(Double min, Double max);
    List<Player> findByFtPercentageBetween(Double min, Double max);
    List<Player> findByTurnoversBetween(Double min, Double max);


}