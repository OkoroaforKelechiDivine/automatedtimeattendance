package herotechconsulting.automatedtimeattendance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendance {

    private LocalDateTime clockIn;

    private LocalDateTime clockOut;

    private LocalDateTime startBreak;

    private LocalDateTime endBreak;
}
