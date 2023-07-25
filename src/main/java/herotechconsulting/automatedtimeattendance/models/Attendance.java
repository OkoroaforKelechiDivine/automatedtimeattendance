package herotechconsulting.automatedtimeattendance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendance {

    @Id
    private String id;

    private String employeeId;

    private LocalDateTime clockIn;

    private LocalDateTime clockOut;

    private String action;

    private LocalDateTime startBreak;

    private LocalDateTime timestamp;

    private LocalDateTime endBreak;
}
