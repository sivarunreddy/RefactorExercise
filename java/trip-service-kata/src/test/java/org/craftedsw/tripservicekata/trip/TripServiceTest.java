package org.craftedsw.tripservicekata.trip;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

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
		sessionUser=new User();
	}
		
	@Test(expected = UserNotLoggedInException.class)
	public void test_getTripsByUser_throws_exception_when_user_not_loggedin()  {
		sessionUser=null;
		tripService.getTripsByUser(new User());
	}
	
	@Test()
	public void test_getTripsByUser_to_return_empty_trip_when_user_is_not_a_friend()  {
		List<Trip> friendTrips=tripService.getTripsByUser(new User());
		assertThat(friendTrips.size(), is(0));
	}
	
	@Test()
	public void test_getTripsByUser_to_return_trips_when_user_is_a_friend()  {
		User friend=new User();
		friend.addFriend(sessionUser);
		List<Trip> friendTrips=tripService.getTripsByUser(friend);
		
		assertThat(friendTrips.size(), is(1));
	}
	
	private class TestTripService extends TripService{
		@Override
		protected User getLoggedUser() {
			return sessionUser;
		}
		
		@Override
		protected List<Trip> getTripsOf(User user) {
			List<Trip> tripList=new ArrayList<Trip>();
			tripList.add(new Trip());
			return tripList;
		}
	}
	
	

}
