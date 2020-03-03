package com.example.procesor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	Map<String, String> departmentMap = new HashMap<>();
	public Processor() {
		departmentMap.put("1", "java");
		departmentMap.put("2", "Python");
		departmentMap.put("4", ".NET");
	}

	@Override
	public User process(User user) throws Exception {
		String department = departmentMap.get(user.getDepartment());
		user.setDepartment(department);
		user.setDate(new Date());
		return user;
	}


}
