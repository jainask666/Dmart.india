package curd.with.cassandra.request;

//import io.swagger.annotations.ApiModelProperty;

public class StudentRequest {
//	@ApiModelProperty(hidden = true) 
	private int id;
//	@ApiModelProperty(hidden = true) 
	private String name;
//	@ApiModelProperty(hidden = true) 
	private String address;
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
		return "StudentRequest [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	
	
}
