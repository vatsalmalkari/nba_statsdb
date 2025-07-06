package basketball.com.example.database.service;

import basketball.com.example.database.model.Player;
import basketball.com.example.database.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component // Marks this class as a Spring component, so it's discovered and managed by Spring
public class CsvDataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    // Spring will automatically inject PlayerRepository here
    public CsvDataLoader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


     // This method runs automatically once the Spring application context is fully loaded.

    @Override
    public void run(String... args) throws Exception {
        // Only load data if the 'players' table is currently empty.
        // This prevents re-loading data if the app is restarted without 'create-drop'.
        if (playerRepository.count() == 0) {
            System.out.println("Database is empty. Attempting to load players from CSV...");
            loadPlayersFromCsv();
        } else {
            System.out.println("Database already contains players. Skipping CSV data load.");
        }
    }


      // Reads and parses player data from the 'data.csv' file located in the classpath.

    private void loadPlayersFromCsv() {
        List<Player> players = new ArrayList<>();
        String filePath = "/data.csv";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(filePath)), StandardCharsets.UTF_8))) {

            if (reader.markSupported()) {
                reader.mark(1024); // Mark the current position
            } else {
                System.err.println("BufferedReader does not support mark/reset. Cannot safely skip header.");
            }

            String line;
            boolean isFirstLine = true; // skip the header row

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    System.out.println("Skipping CSV header: " + line);
                    continue; // Skip the header row
                }

                // Split the line by comma.
                String[] data = line.split(",");


                // There are 18 columns in your header, so we expect at least 18 data points.
                if (data.length >= 18) {
                    try {
                        Player player = new Player();
                        player.setId(parseInteger(data[0]));

                        player.setPlayerName(data[1].trim()); // Player
                        player.setTeam(data[2].trim());        // Team
                        player.setPosition(data[3].trim());    // Position
                        player.setAge(parseInteger(data[4]));  // Age
                        player.setGamesPlayed(parseInteger(data[5])); // Games
                        player.setPointsPerGame(parseDouble(data[6])); // Points
                        player.setReboundsPerGame(parseDouble(data[7])); // Rebounds
                        player.setAssistsPerGame(parseDouble(data[8])); // Assists
                        player.setStealsPerGame(parseDouble(data[9])); // Steals
                        player.setBlocksPerGame(parseDouble(data[10]));// Blocks
                        player.setWinShares(parseDouble(data[11]));   // Win Shares
                        player.setMinutesPerGame(parseDouble(data[12]));// Minutes Played
                        player.setPerRating(parseDouble(data[13]));   // Player Efficiency Rating
                        player.setGamesStarted(parseInteger(data[14]));// Games Started
                        player.setFgPercentage(parseDouble(data[15]));// Field Goal %
                        player.setFtPercentage(parseDouble(data[16]));// Free Throw %
                        player.setTurnovers(parseDouble(data[17]));   // Turnovers

                        players.add(player);
                    } catch (NumberFormatException e) {
                        System.err.println("CSV Data Load Warning: Skipping row due to number format error: '" + line + "' - " + e.getMessage());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("CSV Data Load Warning: Skipping row due to too few columns: '" + line + "' - " + e.getMessage());
                    }
                } else {
                    System.err.println("CSV Data Load Warning: Skipping row due to insufficient columns (expected 18, got " + data.length + "): '" + line + "'");
                }
            }

            if (!players.isEmpty()) {
                // Save all parsed players to the database in a batch
                playerRepository.saveAll(players);
                System.out.println("Successfully loaded " + players.size() + " players from CSV into the database.");
            } else {
                System.out.println("No valid player data found in CSV to load or all rows were skipped.");
            }

        } catch (NullPointerException e) {
            System.err.println("Error: 'data.csv' not found at classpath path '" + filePath + "'. Please check the file location.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during CSV data loading: " + e.getMessage());
            e.printStackTrace();
        }
    }


     // Method to safely parse a String to an Integer.
     // Returns null if the string is null, empty, or not a valid integer.

    private Integer parseInteger(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Parse Error: Could not parse Integer from '" + value + "'");
            return null; // Or throw exception, depending on desired error handling
        }
    }


     // Method to safely parse a String to a Double.
     // Returns null if the string is null, empty, or not a valid double.

    private Double parseDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Parse Error: Could not parse Double from '" + value + "'");
            return null; // Or throw exception
        }
    }
}
