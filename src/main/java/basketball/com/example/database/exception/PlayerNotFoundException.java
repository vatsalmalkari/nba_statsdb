package basketball.com.example.database.exception;
// when a player is not found, it returns this
public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
