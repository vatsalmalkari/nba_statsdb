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
    @Column(name = "player_name") // maps player_name column to this variable
    private String playerName;

    private String team;

    private String position;

    @Min(value = 18, message = "Age must be at least 18.")
    @Max(value = 50, message = "Age must be at most 50.")
    private Integer age;

    @Min(value = 0, message = "Games played must be 0 or more.")
    @Column(name = "games_played") //  map column names to a variable same for all columns
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

    private Double turnovers;

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

    public String getPlayerName() { // Changed getter name
        return playerName;
    }

    public void setPlayerName(String playerName) { // Changed setter name
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

    public Integer getGamesPlayed() { // Changed getter name
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) { // Changed setter name
        this.gamesPlayed = gamesPlayed;
    }

    public Double getPointsPerGame() { // Changed getter name
        return pointsPerGame;
    }

    public void setPointsPerGame(Double pointsPerGame) { // Changed setter name
        this.pointsPerGame = pointsPerGame;
    }

    public Double getReboundsPerGame() { // Changed getter name
        return reboundsPerGame;
    }

    public void setReboundsPerGame(Double reboundsPerGame) { // Changed setter name
        this.reboundsPerGame = reboundsPerGame;
    }

    public Double getAssistsPerGame() { // Changed getter name
        return assistsPerGame;
    }

    public void setAssistsPerGame(Double assistsPerGame) { // Changed setter name
        this.assistsPerGame = assistsPerGame;
    }

    public Double getStealsPerGame() { // Changed getter name
        return stealsPerGame;
    }

    public void setStealsPerGame(Double stealsPerGame) { // Changed setter name
        this.stealsPerGame = stealsPerGame;
    }

    public Double getBlocksPerGame() { // Changed getter name
        return blocksPerGame;
    }

    public void setBlocksPerGame(Double blocksPerGame) { // Changed setter name
        this.blocksPerGame = blocksPerGame;
    }

    public Double getWinShares() { // Changed getter name
        return winShares;
    }

    public void setWinShares(Double winShares) { // Changed setter name
        this.winShares = winShares;
    }

    public Double getMinutesPerGame() { // Changed getter name
        return minutesPerGame;
    }

    public void setMinutesPerGame(Double minutesPerGame) { // Changed setter name
        this.minutesPerGame = minutesPerGame;
    }

    public Double getPerRating() { // Changed getter name
        return perRating;
    }

    public void setPerRating(Double perRating) { // Changed setter name
        this.perRating = perRating;
    }

    public Integer getGamesStarted() { // Changed getter name
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) { // Changed setter name
        this.gamesStarted = gamesStarted;
    }

    public Double getFgPercentage() { // Changed getter name
        return fgPercentage;
    }

    public void setFgPercentage(Double fgPercentage) { // Changed setter name
        this.fgPercentage = fgPercentage;
    }

    public Double getFtPercentage() { // Changed getter name
        return ftPercentage;
    }

    public void setFtPercentage(Double ftPercentage) { // Changed setter name
        this.ftPercentage = ftPercentage;
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
}