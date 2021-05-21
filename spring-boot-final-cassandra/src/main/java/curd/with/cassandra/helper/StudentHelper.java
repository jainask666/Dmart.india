package curd.with.cassandra.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.datastax.oss.driver.shaded.guava.common.base.Optional;

import curd.with.cassandra.model.Student;
import curd.with.cassandra.repository.StudentRepo;
import curd.with.cassandra.request.StudentRequest;
import curd.with.cassandra.response.StudentResponse;

@Component
public class StudentHelper {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String Value_ERROR = "Please add valid Student details";

	@Autowired
	StudentRepo studentRepo;

	public Iterable<Student> findAll() {
		logger.debug("dubbing in findall method of StudentHelper Class");
		logger.info("Getting All The Student Data ");
		return studentRepo.findAll();
	}

	public StudentResponse create(StudentRequest request) {
		logger.debug("Enter into Student Details, Request : StudentRequest : {}", request);
		logger.info("Entry of Student Details");
		StudentResponse response = new StudentResponse();
		Student student = studentRepo.save(new Student(request.getId(), request.getName(), request.getAddress()));
		if (null != student) {
			response.setMessage("Data Entered Successfully");
			response.setStatus(Boolean.TRUE.toString());
			logger.info("Student Data was Vaild  ");
		} else {
			response.setMessage("Data Entered Failed");
			response.setStatus(Boolean.FALSE.toString());
			logger.info(" Student Data was Invaild");
			logger.error(Value_ERROR);
		}
		logger.debug(" Gives Student Deatils,StudentResponse:{} ", response);
		return response;
	}

	public StudentResponse deleteById(int id) {
		logger.debug("dubbing in deletebyId");
		logger.info(" Deleted Student details");
		StudentResponse response = new StudentResponse();
		Student student = studentRepo.findId(id);
		if (null != student) {
			studentRepo.deleteById(id);
			response.setMessage("Data Delete Successfully");
			response.setStatus(Boolean.TRUE.toString());
			logger.info("Deleted Student Data was Valid");
		} else {
			response.setMessage("Data Delete UNSuccessfully");
			response.setStatus(Boolean.FALSE.toString());
			logger.info("Deleted Student Data was Invaild");
		}
		logger.debug(" Gives Student Deatils,StudentResponse:{} ", response);
		return response;
	}

	public StudentResponse update(StudentRequest request) {
		logger.info("Updated Student Details");
		logger.debug(" Enter into Student Deatils,StudentRequest:{} ", request);
		StudentResponse response = new StudentResponse();
		Student student = studentRepo.save(new Student(request.getId(), request.getName(), request.getAddress()));
		if (null != student) {
			response.setMessage("Data Entered Successfully");
			response.setStatus(Boolean.TRUE.toString());
			logger.info(" Updated Student Data was Valid");
		} else {
			response.setMessage("Data Entered Failed");
			response.setStatus(Boolean.FALSE.toString());
			logger.error(Value_ERROR);
			logger.info(" Updated Student Data was Invaild");
		}
		logger.debug(" Updated Student Deatils,StudentResponse:{} ", response);
		return response;
	}

	public int findName(StudentRequest request) {
		
		return studentRepo.findByName(request.getName());
	}

}
