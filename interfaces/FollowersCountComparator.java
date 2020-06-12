package interfaces;

import java.util.Comparator;

import objectstructures.TwitterAccount;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		if (o1.getFollowersCount() > o2.getFollowersCount()) {
			return 1;
		}
		if (o1.getFollowersCount() == o2.getFollowersCount()) {
			return 0;
		}
		else {
			return -1;
		}
		
	}

}
