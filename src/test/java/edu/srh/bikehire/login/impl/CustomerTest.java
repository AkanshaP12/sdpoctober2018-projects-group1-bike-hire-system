package edu.srh.bikehire.login.impl;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.srh.bikehire.exception.BikeHireSystemException;

public class CustomerTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testValidateCustomer() throws BikeHireSystemException {
		thrown.expect(BikeHireSystemException.class);
		
		//fail("Not yet implemented");
		Customer lCustomer = new Customer();
		//lCustomer.setFirstName("Viraj");
		lCustomer.validateCustomer();
		
		
		
	}

}
