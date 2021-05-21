package curd.with.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class SpringBootFinalCassandraApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFinalCassandraApplication.class, args);
		System.out.println("###APP STARTED");
	}

}
