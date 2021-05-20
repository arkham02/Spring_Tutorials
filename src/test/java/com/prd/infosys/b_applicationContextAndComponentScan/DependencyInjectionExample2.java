package com.prd.infosys.b_applicationContextAndComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Component is nothing but a bean managed by Spring IOC
 * 
 * TestContext.xml - all the configurations need by Spring to manage the beans is present
 * <context:component-scan base-package="com.prd.infosys"/>
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/TestContext.xml" })
public class DependencyInjectionExample2 {


	@Autowired
	private GoodMorningService1 service;

	@Test
	public void dummyTest() {
		System.out.println(service.saysHi());
	}
}

/**
 * 
 * Although we have provided @Component and @AutoWired annotations.
 * How would Spring know to search for the component?
 * Who is creating Spring ?
 * (by using SpringJUnit4ClassRunner - it instantiates the spring framework.
 * 	But to instantiate , it needs ApplicationContext)
 *
 */
	@Component
	 class GoodMorningService1 {

		public String saysHi() {
			return "Good Morning";
		}
	}

