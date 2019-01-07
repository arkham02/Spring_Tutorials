package com.prd.infosys.f_applicationContextAndComponentScanJavaContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 
 * context can also be specified by javacode,
 * using @Configuration @ComponentScan
 * 
 * replacing the location attribute in @ContextConfiguration to classes attribute
 *
 */

@Configuration
@ComponentScan(basePackages = { "com.prd.infosys" })
class JavaContext {

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaContext.class)
public class DependencyInjectionExample5 {

	@Autowired
	GoodMorningService2 service;

	@Test
	public void dummyTest() {
		System.out.println(service.saysHi());
	}
}

@Component
class GoodMorningService2 {

	public String saysHi() {
		return "Good Morning";
	}
}
