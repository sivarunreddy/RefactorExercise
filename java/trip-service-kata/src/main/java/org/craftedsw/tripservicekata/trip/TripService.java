package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		return user.isFriend(checkLoggedUser())?getTripsOf(user):new ArrayList<Trip>();
	}

	protected List<Trip> getTripsOf(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

	private User checkLoggedUser() {
		User loggerUser = getLoggedUser();
		if (null == loggerUser) {
			throw new UserNotLoggedInException();
		}
		return loggerUser;
	}
	
	
}
