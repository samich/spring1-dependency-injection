package com.example.hellospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.game.GameConsole;
import com.example.game.GameRunner;
import com.example.game.PacmanGame;

/* Field Injection Example
 * =======================
 * Example of autowiring by field
 * assume we have a business class with two dependency fields
 * we use @Autowired annotation on thos fields
 * and they get autowired, we can see in the toString method
 */
@Component
class BusinessClass{
	
	//autowire the dependencyClass1 property
	@Autowired
	DependencyClass1 dependencyClass1;
	
	@Autowired
	DependencyClass2 dependencyClass2;
	
	public String toString() {
		return "using dependency1: " + dependencyClass1 + " dependency2: " + dependencyClass2;
	}
}

//dependency class 1
@Component
class DependencyClass1{
	
}

//dependency class 2
@Component
class DependencyClass2{
	
}

@Configuration

//we want to scan the same package therefore no need to provide the package path
@ComponentScan
public class DependencyInjectionByField {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionByField.class)){
			
			//see what beans are part of this context
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessClass.class));
		}
		
				
	}

}
