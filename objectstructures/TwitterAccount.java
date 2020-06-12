package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TwitterAccount {
	
	private String userName;
	Tweet tweet;
	private List<TwitterAccount> followers = new ArrayList<TwitterAccount>();
	private List<TwitterAccount> following = new ArrayList<TwitterAccount>();
	
	private List<Tweet> tweets = new ArrayList<>();
	
	public TwitterAccount(String userName) {
		this.userName = userName;
	}
	
	public int getFollowersCount() {
		return followers.size();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void follow(TwitterAccount otherUser) {
		if (this == otherUser) {
			throw new IllegalArgumentException("You can't follow yourself");
		}
		if (!followers.contains(otherUser)) {
			followers.add(otherUser);
			otherUser.followers.add(this);
		}
	}
	
	public void unfollow(TwitterAccount otherUser) {
		if (followers.contains(otherUser)) {
			followers.remove(otherUser);
			otherUser.followers.remove(this);
		}
		else {
			throw new IllegalArgumentException("you are not following this user.");
		}

		
	}
	public boolean isFollowing(TwitterAccount otherUser) {
		return following.contains(otherUser);

	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		return followers.contains(account);
	}
	
	public void tweet(String newTweet) {
		tweets.add(new Tweet(this, text));
	}
	
	public void retweet(Tweet tweet) {
		tweets.add(new Tweet(this, tweet));
	}
	
	public Tweet getTweet(int rankByTime) {
		return tweets.get(tweets.size() - rankByTime);
		
	}
	
	public int getTweetCount() {
		return tweets.size();
	}
	
	public int getRetweetCount() {
		int count = 0;
		for (Tweet tweet : tweets) {
			count += tweet.getRetweetCount();
		}
		return count;
		
	}
}
