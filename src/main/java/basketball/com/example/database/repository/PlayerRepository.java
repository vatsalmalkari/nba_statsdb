package basketball.com.example.database.repository;
import basketball.com.example.database.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository 
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // exact value methods - return players who averaged the exact value provided or are in that age, position, team
     @Query("SELECT p FROM Player p WHERE LOWER(p.team) = LOWER(:team)")
    List<Player> findByTeam(@Param("team") String team);
    List<Player> findByPlayerNameIgnoreCase(@Param("name") String name);
    List<Player> findByTeamIgnoreCase(@Param("team") String team);
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
    List<Player> findByFgPercentage(Double fgPercentage);
    List<Player> findByFtPercentage(Double ftPercentage);
    List<Player> findByTurnovers(Double turnovers);
    List<Player> findByThreePointPercentage(Double threePointPercentage);
    List<Player> findByEffectiveFieldGoalPercentage(Double effectiveFieldGoalPercentage);
    List<Player> findByTrueShootingPercentage(Double trueShootingPercentage);
    List<Player> findByUsageRate(Double usageRate);
    List<Player> findByOffensiveRating(Double offensiveRating);
    List<Player> findByDefensiveRating(Double defensiveRating);
    @Query("SELECT p FROM Player p WHERE LOWER(p.playerName) = LOWER(:name)")
    List<Player> findByPlayerName(@Param("name") String name);


    // range of values methods - returns players who averaged between min and max
    List<Player> findByPointsPerGameBetween(Double min, Double max); 
    List<Player> findByReboundsPerGameBetween(Double min, Double max); 
    List<Player> findByAssistsPerGameBetween(Double min, Double max);
    List<Player> findByStealsPerGameBetween(Double min, Double max);
    List<Player> findByBlocksPerGameBetween(Double min, Double max);
    List<Player> findByAgeBetween(Integer min, Integer max);
    List<Player> findByFgPercentageBetween(Double min, Double max);
    List<Player> findByFtPercentageBetween(Double min, Double max);
    List<Player> findByTurnoversBetween(Double min, Double max);
    List<Player> findByThreePointPercentageBetween(Double min, Double max);
    List<Player> findByEffectiveFieldGoalPercentageBetween(Double min, Double max);
    List<Player> findByTrueShootingPercentageBetween(Double min, Double max);
    List<Player> findByUsageRateBetween(Double min, Double max);
    List<Player> findByOffensiveRatingBetween(Double min, Double max);
    List<Player> findByDefensiveRatingBetween(Double min, Double max);



}