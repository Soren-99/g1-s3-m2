package sorenrahimi.g1s3m2.payloads.errors;

import java.time.LocalDateTime;
import java.util.Date;

public record ErrorsPayload(
        String message,
        LocalDateTime timestamp) { }


