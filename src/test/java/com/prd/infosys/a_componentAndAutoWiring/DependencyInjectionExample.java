package com.prd.infosys.a_componentAndAutoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * Dependency Injection - Eg. business class depends of data class which depends on
 * datasource class. 
 * 
 * We would want spring to take over the initialization and
 * the injection of them in the required classes. 
 * 
 * Spring IOC container - takes
 * care of creating the beans that are needed (creating instances), making it
 * available, destroying it
 * 
 * 1. Spring -- > Create a GoodMorning Service == > @Component
 * 2. Spring -- > Needs to give DependencyInjectionExample the created GoodMorning service ==> @Autowired
 *
 */


public class DependencyInjectionExample {

	/**
	 * two things are happening in the below commented line 
	 * GoodMorningService service = new GoodMorningService();
	 * 
	 * 1. an object of the class is created 
	 * 2. the object is assigned to the Class reference
	 * 
	 * Spring would also need to do the same using @Component and @AutoWiring
	 */

	@Autowired
	GoodMorningService service;

	@Test
	public void dummyTest() {
		System.out.println(service.saysHi());
	}
}

	@Component
	 class GoodMorningService {

		public String saysHi() {
			return "Good Morning";
		}
	}

