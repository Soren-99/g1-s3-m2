package sorenrahimi.g1s3m2.payloads.errors;

import java.time.LocalDateTime;

public record ErrorsPayloadWithList(
        String message,
        LocalDateTime timestamp
) {
}
