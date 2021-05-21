package curd.with.cassandra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.datastax.oss.driver.shaded.guava.common.base.Optional;

import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;

import curd.with.cassandra.base.constant.ResourceEndPoint;
import curd.with.cassandra.model.Student;
import curd.with.cassandra.request.StudentRequest;
import curd.with.cassandra.response.StudentResponse;
import curd.with.cassandra.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(ResourceEndPoint.BASE_ROUTE)
@Api(value = "/student", tags = "Student Management")
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentService studentService;

	/**
	 * This method is used to find list of entity by given multiple field names and
	 * values
	 *
	 * @param entityClass {@link T} contains Entity class information
	 * @param key         {@link List<String>} contains field names
	 * @param tableName   {@link String} contains table name information
	 * @param value       {@link List} contains field values information
	 * @return {@link List<E>} return any class
	 */
	@RequestMapping(method = RequestMethod.GET, value = ResourceEndPoint.GET_STUDENT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "it will Fetch all records of items(students)", tags = { "Student Management" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Default Student Data"),
			@ApiResponse(code = 404, message = "Invalid StudentId"),
			@ApiResponse(code = 500, message = "Internal server error") })

	public List<Student> getAllStudent() {
		logger.debug("Getting all Student");
		logger.info("** Get dummy static data to DB **");
		return studentService.getAllStudent();
	}

	@PostMapping(value = ResourceEndPoint.POST_STUDENT, produces = MediaType.APPLICATION_JSON_VALUE)

	@ApiOperation(value = "Here you can insert  new Items(Student)", tags = { "Student Management" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Default Student Data"),
			@ApiResponse(code = 404, message = "Invalid StudentId"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public StudentResponse createStudent(@RequestBody StudentRequest request) {
		logger.debug("StudentController : method name: post, Description: Create  Student Data , Request: {}", request);
		logger.info("** Created dummy static data to DB **");
		StudentResponse response = studentService.create(request);
		logger.debug("StudentController : method name: post, Description: Create Student Data , response: {}",
				response);
		return response;
	}

	@DeleteMapping(ResourceEndPoint.DELETE_STUDENT)

	@ApiOperation(value = "Here you can Delete the items(student)", tags = { "Student Management" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Default Student Data"),
			@ApiResponse(code = 404, message = "Invalid StudentId"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public StudentResponse deleteById(@PathVariable("id") int id) {
		logger.info("** Deleted dummy static data to DB **");
		StudentResponse response = studentService.delete(id);
		logger.debug("StudentController : method name: Delete, Description: Delete Student Data , Response: {}",
				response);
		return response;

	}

	@ApiOperation(value = "Here you can update the items(Student)", tags = { "Student Management" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Default Student Data"),
			@ApiResponse(code = 404, message = "Invalid StudentId"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@RequestMapping(method = RequestMethod.PUT, value = ResourceEndPoint.UPDATE_STUDENT, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse UpdateStudent(@RequestBody StudentRequest request) {
		logger.debug("StudentController : method name: update, Description: Update  Student Data , Request: {}",
				request);
		logger.info("** Updated dummy static data to DB **");
		StudentResponse response = studentService.update(request);
		logger.debug("StudentController : method name: update, Description: Update  Student Data , Response: {}",
				response);
		return response;
	}

}
