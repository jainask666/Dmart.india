package curd.with.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import io.swagger.annotations.ApiModelProperty;

@Table("student")
//@JsonIgnoreProperties
public class Student {

//	@ApiModelProperty(hidden = true)
	@PrimaryKey
	private int id;

//	@ApiModelProperty(hidden = true)
	private String name;

//	@ApiModelProperty(hidden = true)
	private String address;

	public Student() {

	}

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
