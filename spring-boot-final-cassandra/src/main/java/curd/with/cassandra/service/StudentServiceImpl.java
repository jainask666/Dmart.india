package curd.with.cassandra.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curd.with.cassandra.base.utils.CommonUtils;

//import com.datastax.oss.driver.shaded.guava.common.base.Optional;

import curd.with.cassandra.helper.StudentHelper;
import curd.with.cassandra.model.Student;
import curd.with.cassandra.request.StudentRequest;
import curd.with.cassandra.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentHelper studentHelper;

	@Override
	public List<Student> getAllStudent() {
		logger.info("StudentServiceImpl : method name: getAllStudent");
		List<Student> student = new ArrayList<>();
		studentHelper.findAll().forEach(student::add);
		logger.debug("Debugging getallStudent method of StudentServiceImpl");
		return student;
	}

	@Override
	public StudentResponse create(StudentRequest request) {
		logger.info("StudentServiceImpl : method name: create, Description: post all the Student data");
		logger.debug("Enter into StudentServiceImpl.CreateStudent, Request  : {} ", request);
		StudentResponse response = new StudentResponse();
		int cntname = 0;
		try {
			if (!CommonUtils.isEmpty(request.getAddress()) && !CommonUtils.isEmpty(request.getName())) {
				cntname = studentHelper.findName(request);
				if (cntname == 0) {
					if (!CommonUtils.check(request.getName())) {
						response = studentHelper.create(request);
					} else {
						response.setStatus(Boolean.FALSE.toString());
						response.setMessage("Please Use Valid Alphabet Char");
					}
				} else {
					response.setStatus(Boolean.FALSE.toString());
					response.setMessage("Name already exist");
				}
			} else {
				logger.info("You have Enter Invaild Data");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}

		} catch (Exception e) {
			logger.info("****** Exception Error Occured ******");
			;
			logger.error("Error while creating Student : ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("exception during creation");

		}
		logger.debug("Response of StudentServiceImpl.Create = {} ", response);
		return response;

	}

	@Override
	public StudentResponse delete(int id) {
		logger.info("StudentServiceImpl : method name: delete, Description: deleted  the Student data");
		logger.debug("Debugging at delete method");
		StudentResponse response = new StudentResponse();
		response = studentHelper.deleteById(id);
		logger.debug("Deleteing all employees.");
		return response;
	}

	@Override
	public StudentResponse update(StudentRequest request) {
		logger.debug("Debugging at update method");
		logger.info("StudentServiceImpl : method name: update, Description: update the Student data");
		StudentResponse response = new StudentResponse();
		try {
			if (!CommonUtils.isEmpty(request.getAddress()) && !CommonUtils.isEmpty(request.getName())) {
				response = studentHelper.update(request);
			} else {
				logger.info("You have enter invaild data");
				response.setStatus(Boolean.FALSE.toString());
				response.setMessage("Enter valid Data");
			}
		} catch (Exception e) {
			logger.info("****** Exception Error Occured ******");
			logger.error("Error while update Student : ", e);
			response.setStatus(Boolean.FALSE.toString());
			response.setMessage("exception in update");
		}
		logger.debug("Response of StudentServiceImpl.update = {} ", response);
		return response;

	}

}
