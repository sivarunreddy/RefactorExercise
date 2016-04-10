package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.*;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;


public class TripServiceTest {

	private TripService tripService;
	
	@Before
	public void setup(){
		tripService=new TestTripService();
	}
		
	@Test(expected = UserNotLoggedInException.class)
	public void test_getTripsByUser_for_user_not_loggedin_exception() throws Exception {
		
		tripService.getTripsByUser(null);
	}
	
	private class TestTripService extends TripService{
		@Override
		protected User getLoggedUser() {
			return null;
		}
	}
	
	

}
