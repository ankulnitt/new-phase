package com.learn.spring.lifecycle.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.lifecycle.Employee;
import com.learn.spring.lifecycle.EmployeeService;
import com.learn.spring.lifecycle.MyEmployeeService;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		System.out.println("Spring Context initialized");

		MyEmployeeService service = ctx.getBean("myEmployeeService", MyEmployeeService.class);
//		EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);

		System.out.println("Bean retrieved from Spring Context");

		System.out.println("Employee Name=" + service.getEmployee().getName());

		
		Employee employee1 = (Employee) ctx.getBean("employee");
		System.out.println(employee1);
		
		System.out.println(employee1.getEmpAddress().getLine1());
		
//		Employee employee2 = (Employee) ctx.getBean("employee2");
//		System.out.println(employee2);
		ctx.close();
		System.out.println("Spring Context Closed");
	}

}