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

/* Constructor Dependency Injection Example
 * ======+=================
 * Example of autowiring by constructor injection
 * In this example we have used @Autowired annotation for constructor
 * however it is not required
 * and they get autowired, we can see in the toString method
 * dependency injection by constructor is recommended dependency injection method
 */
@Component
class BusinessClass2{
	
	//DependencyClass1, 2 are in DependencyInjectionByField file
	DependencyClass1 dependencyClass1;
	DependencyClass2 dependencyClass2;
	
	//@Autowired is not required for constructor
	@Autowired
	public BusinessClass2(DependencyClass1 dependencyClass1, DependencyClass2 dependencyClass2 ) {
		System.out.println("Constructor Injection - BusinessClass2 constructor");
		this.dependencyClass1 = dependencyClass1;
		this.dependencyClass2 = dependencyClass2;
	}
	
	public String toString() {
		return "using dependency1: " + dependencyClass1 + " dependency1: " + dependencyClass2;
	}
}

//dependency class 5
@Component
class DependencyClass5{
	
}

//dependency class 6
@Component
class DependencyClass6{
	
}


@Configuration

//we want to scan the same package therefore no need to provide the package path
@ComponentScan
public class DependencyInjectionByConstructor {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionByConstructor.class)){
			
			//see what beans are part of this context
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);			
			System.out.println(context.getBean(BusinessClass2.class));
		}
		
				
	}

}
