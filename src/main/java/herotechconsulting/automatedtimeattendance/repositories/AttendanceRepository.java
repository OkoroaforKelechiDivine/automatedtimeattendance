package herotechconsulting.automatedtimeattendance.repositories;

import herotechconsulting.automatedtimeattendance.models.Attendance;
import herotechconsulting.automatedtimeattendance.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    List<Attendance> findByEmployee(Employee employee);
}
