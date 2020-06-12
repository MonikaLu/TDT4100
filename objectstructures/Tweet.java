package objectstructures;

public class Tweet {
	
	private TwitterAccount owner;
	private String tweet;
	private Tweet originalTweet = null;
	private int retweetCount = 0;
	
	public Tweet(TwitterAccount userName, String tweet) {
		this.owner = userName;
		this.tweet = tweet;
	}
	
	public Tweet(TwitterAccount userName, Tweet tweet) {
		Tweet originalOriginalTweet = getOriginalTweet();
		if (originalTweet.getOwner() == owner || (originalOriginalTweet != null && originalOriginalTweet.getOwner() == owner)) {
			throw new IllegalArgumentException("This is your own post!");
		}
		this.owner = userName;
		this.originalTweet = (originalOriginalTweet != null ? originalOriginalTweet : originalTweet);
	}
	
	public String getText() {
		return tweet;
	}
	
	public TwitterAccount getOwner() {
		return owner;
		
	}
	
	public Tweet getOriginalTweet() {
		return originalTweet;
	}
	
	public int getRetweetCount() {
		return retweetCount;
	}
}
	
	


