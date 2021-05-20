package com.prd.infosys.i_aop;

/**

**Static - Compile Time**
Aspect : Eg. Logging. (input and output parameters) 
		   Aspect is the concern that we are trying to implement generically. Ex: logging, transaction management.
 		   Advice is the specific aspect of the concern we are implementing.

Pointcut : (Cross-section) An expression which determines what are the methods that the Advice should be applied on.
				execution(* com.prd.infosys.i_aop.HiByeService.*(..))

Advice: action taken by an aspect at a particular join point. 
			Different types of advice include "around," "before" and "after" advice. 
			(Advice types are discussed below.)
 			Many AOP frameworks, including Spring, model an advice as an interceptor,
			maintaining a chain of interceptors around the join point.

**Dynamic - Runtime**
Join point: a point during the execution of a program, such as the execution of a method or the handling of an exception.
In Spring AOP, a join point always represents a method execution.

Weaving: linking aspects with other application types or objects to create an advised object. 
			This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime.
 			Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.

 --
Spring AOP is very simple implementation of AOP concepts.
Its an ideal fit If the needs of an application are simple like
AspectJ is a full fledged AOP framework that helps you
Advise objects not managed by the Spring container .
Advise join points other than simple method executions (for example, field get or set join points).
*/


/**
 * Scenarios when AOP can be used 
 * Business Layer > Data Layer > Database
 * 
 * Everytime a business method is called , i may want to log a particular statement 
 * E.g what is the method called, what are the input parameters, return values, time to execute, if there is an exception
 * 
 * When to go for other AOP frameworks - methods not managed by spring, value of an object changes
 * Spring AOP can also do before and after, but not field level things
 * 
 * Transaction management using AOP 
 * 
 */
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.prd.infosys.i_aop" })
class SpringContextAOP {
}

@Aspect
@Component
class MyAspect {
	
	@Before("execution(* com.prd.infosys.i_aop.HiByeService.*(..))")
	
	public void before(JoinPoint joinPoint) {
		System.out.print("Before ");
		System.out.print(joinPoint.getSignature().getName() + " called with ");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	
	
	@AfterReturning(
			pointcut = "execution(* com.prd.infosys.i_aop.HiByeService.*(..))", 
			returning = "result") //since we also want the return value
	
	public void after(JoinPoint joinPoint, 
						Object result) {
		System.out.print("After ");
		System.out.print(joinPoint.getSignature().getName());
		System.out.println(" result is " + result);
	}

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class AOPExampleTest {

	@Autowired
	private HiByeService service;

	@Test
	public void testSomething() {
		service.sayHi("in28Minutes");
		service.sayBye();
		service.returnSomething();
	}

}

@Component
class HiByeService {
	public void sayHi(String name) {
		System.out.println("Hi " + name);
	}

	public void sayBye() {
		System.out.println("Bye");
	}

	public String returnSomething() {
		return "Hi Bye";
	}
}
