package curd.with.cassandra.service;

import java.util.List;

import curd.with.cassandra.model.Student;

//import java.util.List;

//import com.datastax.oss.driver.shaded.guava.common.base.Optional;

//import curd.with.cassandra.model.Student;
import curd.with.cassandra.request.StudentRequest;
import curd.with.cassandra.response.StudentResponse;

public interface StudentService {

	List<Student> getAllStudent();

	StudentResponse create(StudentRequest request);

	StudentResponse delete(int id);

	StudentResponse update(StudentRequest request);

	// Student delete(Student student);

}
