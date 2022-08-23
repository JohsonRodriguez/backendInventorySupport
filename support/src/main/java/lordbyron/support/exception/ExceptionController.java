package lordbyron.support.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> userNotFoundErrorHandling(NotFoundException exception) {
        var errorDetails = new ErrorDetails(
                new Date(),
                "System Inventory SUpport Byron exception!",
                exception.getMessage()
        );
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
