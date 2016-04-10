package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.*;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;


public class TripServiceTest {

	private TripService tripService;
	private User sessionUser;
	
	@Before
	public void setup(){
		tripService=new TestTripService();
	}
		
	@Test(expected = UserNotLoggedInException.class)
	public void test_getTripsByUser_for_user_not_loggedin_exception()  {
		tripService.getTripsByUser(new User());
	}
	
	@Test()
	public void test_getTripsByUser_to_return_empty_trip_when_not_a_friend()  {
		sessionUser=new User();
		tripService.getTripsByUser(new User());
	}
	
	private class TestTripService extends TripService{
		@Override
		protected User getLoggedUser() {
			return sessionUser;
		}
	}
	
	

}
