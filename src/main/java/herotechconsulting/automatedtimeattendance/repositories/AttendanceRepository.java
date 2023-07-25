package herotechconsulting.automatedtimeattendance.repositories;

import herotechconsulting.automatedtimeattendance.models.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttendanceRepository extends MongoRepository<Attendance, String> {

}
