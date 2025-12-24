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

@Component
public class CsvDataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    public CsvDataLoader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) {
        if (playerRepository.count() == 0) {
            System.out.println("[DataLoader] Database empty → Loading CSV...");
            loadPlayersFromCsv();
        } else {
            System.out.println("[DataLoader] Database already populated → Skipping CSV load.");
        }
    }

    private void loadPlayersFromCsv() {
        List<Player> players = new ArrayList<>();
        String filePath = "/data.csv";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(filePath)),
                StandardCharsets.UTF_8))) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {

                if (isHeader) { 
                    isHeader = false; 
                    System.out.println("[DataLoader] Skipping header: " + line);
                    continue; 
                }

                String[] data = line.split(",");

                // Validate correct CSV column count
                if (data.length < 18) {
                    System.err.println("[DataLoader] Skipping row (expected 18 columns): " + line);
                    continue;
                }

                try {
                    Player p = new Player();

                    p.setId(parseInteger(data[0]));
                    p.setPlayerName(data[1].trim());
                    p.setTeam(data[2].trim());
                    p.setPosition(data[3].trim());
                    p.setAge(parseInteger(data[4]));
                    p.setGamesPlayed(parseInteger(data[5]));
                    p.setPointsPerGame(parseDouble(data[6]));
                    p.setReboundsPerGame(parseDouble(data[7]));
                    p.setAssistsPerGame(parseDouble(data[8]));
                    p.setStealsPerGame(parseDouble(data[9]));
                    p.setBlocksPerGame(parseDouble(data[10]));
                    p.setWinShares(parseDouble(data[11]));
                    p.setMinutesPerGame(parseDouble(data[12]));
                    p.setPerRating(parseDouble(data[13]));
                    p.setGamesStarted(parseInteger(data[14]));
                    p.setFgPercentage(parseDouble(data[15]));
                    p.setFtPercentage(parseDouble(data[16]));
                    p.setTurnovers(parseDouble(data[17]));

                    players.add(p);

                } catch (Exception e) {
                    System.err.println("[DataLoader] Skipping malformed row: " + line);
                }
            }

            playerRepository.saveAll(players);
            System.out.println("[DataLoader] Loaded " + players.size() + " players from CSV.");

        } catch (NullPointerException e) {
            System.err.println("[ERROR] data.csv not found in classpath: " + filePath);
        } catch (Exception e) {
            System.err.println("[ERROR] Unexpected CSV load error: " + e.getMessage());
        }
    }

    private Integer parseInteger(String value) {
        try {
            return value == null || value.isBlank() ? null : Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("[ParseInt] Invalid integer: " + value);
            return null;
        }
    }

    private Double parseDouble(String value) {
        try {
            return value == null || value.isBlank() ? null : Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("[ParseDouble] Invalid double: " + value);
            return null;
        }
    }
}
