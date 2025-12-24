package basketball.com.example.database.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
@Entity
@Table(name = "players")
public class Player implements Serializable {
    public String setPlayerName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Player name is required.")
    @Column(name = "player_name") 
    private String playerName;
    @Column(name = "team")
    private String team;
    private String position;
    @Min(value = 18, message = "Age must be at least 18.")
    @Max(value = 50, message = "Age must be at most 50.")
    private Integer age;

    @Min(value = 0, message = "Games played must be 0 or more.")
    @Column(name = "games_played") 
    private Integer gamesPlayed;

    @DecimalMin(value = "0.0", message = "Points per game must be >= 0.")
    @Column(name = "points_per_game")
    private Double pointsPerGame;

    @Column(name = "rebounds_per_game")
    private Double reboundsPerGame;

    @Column(name = "assists_per_game")
    private Double assistsPerGame;

    @Column(name = "steals_per_game")
    private Double stealsPerGame;

    @Column(name = "blocks_per_game")
    private Double blocksPerGame;

    @Column(name = "win_shares")
    private Double winShares;

    @Column(name = "minutes_per_game")
    private Double minutesPerGame;

    @Column(name = "per_rating")
    private Double perRating;

    @Column(name = "games_started")
    private Integer gamesStarted;

    @Column(name = "fg_percentage")
    private Double fgPercentage;

    @Column(name = "ft_percentage")
    private Double ftPercentage;

    @Column(name = "turnovers")
    private Double turnovers;
    @Column(name = "three_point_percentage")
    private Double threePointPercentage;

    @Column(name = "effective_field_goal_percentage")
    private Double effectiveFieldGoalPercentage;

    @Column(name = "true_shooting_percentage")
    private Double trueShootingPercentage;

    @Column(name = "usage_rate")
    private Double usageRate;

    @Column(name = "offensive_rating")
    private Double offensiveRating;

    @Column(name = "defensive_rating")
    private Double defensiveRating;


    public Player(int i, String leBronJames, String lal, String sf, int i1, int i2, double v, double v1, double v2, double v3, double v4, double v5, double v6, double v7, int i3, double v8, double v9, double v10) {
        this.id = i;
        this.playerName = leBronJames;
        this.team = lal;
        this.position = sf;
        this.age = i1;
        this.gamesPlayed = i2;
        this.pointsPerGame = v;
        this.reboundsPerGame = v1;
        this.assistsPerGame = v2;
        this.stealsPerGame = v3;
        this.blocksPerGame = v4;
        this.winShares = v5;
        this.minutesPerGame = v6;
        this.perRating = v7;
        this.gamesStarted = i3;
        this.fgPercentage = v8;
        this.ftPercentage = v9;
        this.turnovers = v10;

    }

    public Player() {
    }
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() { 
        return playerName;
    }

    public void setPlayerName(String playerName) { 
        this.playerName = playerName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGamesPlayed() { 
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Double getPointsPerGame() { 
        return pointsPerGame;
    }

    public void setPointsPerGame(Double pointsPerGame) { 
        this.pointsPerGame = pointsPerGame;
    }

    public Double getReboundsPerGame() { 
        return reboundsPerGame;
    }

    public void setReboundsPerGame(Double reboundsPerGame) { 
        this.reboundsPerGame = reboundsPerGame;
    }

    public Double getAssistsPerGame() { 
        return assistsPerGame;
    }

    public void setAssistsPerGame(Double assistsPerGame) { 
        this.assistsPerGame = assistsPerGame;
    }

    public Double getStealsPerGame() { 
        return stealsPerGame;
    }

    public void setStealsPerGame(Double stealsPerGame) {
        this.stealsPerGame = stealsPerGame;
    }

    public Double getBlocksPerGame() { 
        return blocksPerGame;
    }

    public void setBlocksPerGame(Double blocksPerGame) { 
        this.blocksPerGame = blocksPerGame;
    }

    public Double getWinShares() {
        return winShares;
    }

    public void setWinShares(Double winShares) { 
        this.winShares = winShares;
    }

    public Double getMinutesPerGame() { 
        return minutesPerGame;
    }

    public void setMinutesPerGame(Double minutesPerGame) { 
        this.minutesPerGame = minutesPerGame;
    }

    public Double getPerRating() {
        return perRating;
    }

    public void setPerRating(Double perRating) { 
        this.perRating = perRating;
    }

    public Integer getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) { 
        this.gamesStarted = gamesStarted;
    }

    public Double getFgPercentage() { 
        return fgPercentage;
    }

    public void setFgPercentage(Double fgPercentage) { 
        this.fgPercentage = fgPercentage;
    }

    public Double getFtPercentage() { 
        return ftPercentage;
    }

    public void setFtPercentage(Double ftPercentage) { 
        this.ftPercentage = ftPercentage;
    }

    public Double getThreePointPercentage() {
        return threePointPercentage;
    }
    public void setThreePointPercentage(Double threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    public Double getEffectiveFieldGoalPercentage() {
        return effectiveFieldGoalPercentage;
    }

    public void setEffectiveFieldGoalPercentage(Double effectiveFieldGoalPercentage) {
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
    }

    public Double getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Double turnovers) {
        this.turnovers = turnovers;
    }

    public Integer getGames_played() {
        return gamesPlayed;
    }

    public Double getPoints_per_game() {
        return pointsPerGame;
    }

    public Double getRebounds_per_game() {
        return reboundsPerGame;
    }

    public Double getAssists_per_game() {
        return assistsPerGame;
    }

    public Double getSteals_per_game() {
        return stealsPerGame;
    }
    public Double getBlocks_per_game() {
        return blocksPerGame;
    }
    public Double getWin_shares() {
        return winShares;
    }
    public Double getMinutes_per_game() {
        return minutesPerGame;
    }

    public Double getPer_rating() {
        return perRating;
    }
    public Integer getGames_started() {
        return gamesStarted;
    }
    public Double getFg_percentage() {
        return fgPercentage;
    }
    public Double getFt_percentage() {
        return ftPercentage;
    }
    public Double getTurnovers_per_game() {
        return turnovers;
    }
    public Double getTrueShootingPercentage() {
        return trueShootingPercentage;
    }
    public void setTrueShootingPercentage(Double trueShootingPercentage) {
        this.trueShootingPercentage = trueShootingPercentage;
    }
    public Double getUsageRate() {
        return usageRate;
    }
    public void setUsageRate(Double usageRate) {
        this.usageRate = usageRate;
    }
    public Double getOffensiveRating() {
        return offensiveRating;
    }
    public void setOffensiveRating(Double offensiveRating) {
        this.offensiveRating = offensiveRating;
    }
    public Double getDefensiveRating() {
        return defensiveRating;
    }
    public void setDefensiveRating(Double defensiveRating) {
        this.defensiveRating = defensiveRating;
    }

    
}