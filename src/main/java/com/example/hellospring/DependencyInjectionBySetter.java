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

/* Setter Injection Example
 * ======+=================
 * Example of autowiring by field
 * assume we have a business class with two dependency fields
 * we use @Autowired annotation on thos fields
 * and they get autowired, we can see in the toString method
 */
@Component
class BusinessClass1{
	
	//DependencyClass1, 2 are in DependencyInjectionByField file
	DependencyClass1 dependencyClass1;
	DependencyClass2 dependencyClass2;
	
	@Autowired
	public void setDependencyClass1(DependencyClass1 dependencyClass1) {
		//as we are using Autowired on setter, we can verify that it runs automatically
		System.out.println("Setter Injection 1- setDependencyClass1");
		this.dependencyClass1 = dependencyClass1;
	}
	
	@Autowired
	public void setDependencyClass2(DependencyClass2 dependencyClass2) {
		//as we are using Autowired on setter, we can verify that it runs automatically
		System.out.println("Setter Injection 2 - setDependencyClass2");
		this.dependencyClass2 = dependencyClass2;
	}
		
	
	public String toString() {
		return "using dependency1: " + dependencyClass1 + " dependency2: " + dependencyClass2;
	}
}

@Configuration
//we want to scan the same package therefore no need to provide the package path
@ComponentScan
public class DependencyInjectionBySetter {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionBySetter.class)){
			
			//see what beans are part of this context
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessClass1.class));
		}
		
				
	}

}
