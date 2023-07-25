package herotechconsulting.automatedtimeattendance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    private String id;

    private String name;

    private String role;

    private Boolean clockedIn = false;

    private Boolean onBreak = false;

    public boolean isClockedIn() {
        return clockedIn;
    }

    public boolean isOnBreak() {
        return onBreak;
    }
}
