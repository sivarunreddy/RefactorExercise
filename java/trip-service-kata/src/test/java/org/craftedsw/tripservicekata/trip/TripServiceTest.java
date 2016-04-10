package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.*;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.junit.Before;
import org.junit.Test;


public class TripServiceTest {

	private TripService tripService;
	
	@Before
	public void setup(){
		tripService=new TripService();
	}
		
	@Test(expected = UserNotLoggedInException.class)
	public void test_getTripsByUser_for_user_not_loggedin_exception() throws Exception {
		//This test case will fail due to UserSession.getLoggedUser() method
		tripService.getTripsByUser(null);
	}
	
	

}
