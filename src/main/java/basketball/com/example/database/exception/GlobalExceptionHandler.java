package basketball.com.example.database.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice // Handles exceptions across all controllers
public class GlobalExceptionHandler {

    // 404 - When player not found
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handlePlayerNotFound(PlayerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // 400 - When input validation fails
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getMessage());
    }

    // 500 - Catch-all for other errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.internalServerError().body("Error: " + ex.getMessage());
    }
}