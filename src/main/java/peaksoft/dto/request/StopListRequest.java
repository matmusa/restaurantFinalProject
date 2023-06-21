package peaksoft.dto.request;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public record StopListRequest(
         String reason,
         LocalDate valid
) {
}
