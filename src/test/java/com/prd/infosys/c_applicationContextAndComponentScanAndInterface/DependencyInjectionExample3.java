package com.prd.infosys.c_applicationContextAndComponentScanAndInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Even though we have autowired the HiService interface and not the implementation ,
 * it will still work as Spring finds the implementation of those interfaces,
 * but only if there is ONE impl
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/TestContext.xml" })
public class DependencyInjectionExample3 {

	@Autowired
	HiService service;

	@Test
	public void dummyTest() {
		System.out.println(service.saysHi());
	}
}

@Component
class GoodMorningServiceImpl implements HiService {

	public String saysHi() {
		return "Good Morning";
	}
}
