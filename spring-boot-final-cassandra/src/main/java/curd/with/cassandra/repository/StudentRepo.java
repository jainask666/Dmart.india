package curd.with.cassandra.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import curd.with.cassandra.model.Student;

public interface StudentRepo extends CassandraRepository<Student,Integer>


{

	@Query(value = "Select * from Student where id=:id")
	public Student findId(int id);

	@Query(value = "SELECT count(name) FROM Student WHERE name =:name ALLOW FILTERING", allowFiltering = true)
	public int findByName(String name);
	
}
