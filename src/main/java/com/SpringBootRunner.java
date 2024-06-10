package com;
//all packages having same name that start with com 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication annotation marks it as a Spring Boot application.

//combines three commonly used Spring annotations (@EnableAutoConfiguration,
//@ComponentScan, and @Configuration) into one, simplifying the configuration 
//process for Spring Boot applications.
public class SpringBootRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);// write name of the class , then name of the string args
//SpringApplication.run() method is the main entry point for starting a Spring
//boot application. it takes two paramaters
//When you run this application, Spring Boot will start up, 
//automatically configure itself based on your classpath and 
//configuration, and then run your application.		
	}

}
