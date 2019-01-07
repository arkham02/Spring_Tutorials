package com.prd.infosys.d_applicationContextAndComponentScanAndInterfaceAndMultipleImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/TestContext.xml" })
public class DependencyInjectionExample4 {

	/**
	 * If there are multiple impl of an interface, one of the ways to avoid conflict
	 * 1. is to use the name of the class as the reference variable which is autowired
	 * 2. use a Qualifier
	 * 3. Put Impl classes in different packages and do component-scan on the desired package only
	 */

	/*
	 * @Autowired HiService goodMorningServiceImpl1;
	 * 
	 * @Test public void dummyTest() {
	 * System.out.println(goodMorningServiceImpl1.saysHi()); }
	 */

	@Autowired
	@Qualifier(value="goodNightServiceImpl1")
	HiService1 service1;

	
	@Test
	public void dummyTest() {
		System.out.println(service1.saysHi());
	}

}

@Component
class GoodMorningServiceImpl1 implements HiService1 {

	public String saysHi() {
		return "Good Morning";
	}

}

@Component
class GoodNightServiceImpl1 implements HiService1 {

	public String saysHi() {
		return "Good Night";
	}
}