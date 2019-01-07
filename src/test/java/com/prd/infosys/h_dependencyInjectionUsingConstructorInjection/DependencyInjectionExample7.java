package com.prd.infosys.h_dependencyInjectionUsingConstructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;



/**
 * 
 * Dependency Injection works even if the reference is private as Spring uses reflection
 * If we do not want this , we can asking Spring to use setter (Setter Injection)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/TestContext.xml" })
public class DependencyInjectionExample7 {

	

}
