package curd.with.cassandra.response;

//import io.swagger.annotations.ApiModelProperty;

public class StudentResponse {

//	@ApiModelProperty(hidden = true) 
	private String status;
//	@ApiModelProperty(hidden = true) 
	private String message;

//	@ApiModelProperty(hidden = true) 
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentResponse [status=" + status + ", message=" + message + "]";
	}

}
