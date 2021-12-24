package com.connect.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		//Database d=new Database();
		//System.out.println(d.checkEmail("moaz1@gmail.com"));
		
		//System.out.println(d.checkUser("moaz1@gmail.com" , "123456"));
		//Graduate user=new Graduate("Moaz Nabil","M" , "0100000" ,"Hi" , "23-2-2000" , "omarShonshory@gmail.com" , "123456879" , "url","2023" );
		//user.addExperience(new Experience("companyName", "location", "startDate", "endDate", "position"));
		//System.out.println(d.insertGraduate(user));
		
	}
}
