/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2018/5/14
 */


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "64nOwIAquX6fXfiRO1d36ti4f";
    private final static String CONSUMER_KEY_SECRET = "xtthnNiEhZcznukzxsKNrIHp3buqiCQhQQr7vLut6AZ44OieOl";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Mega");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "MPdpVdPxDOB8xzrwElgOt5NRT4utygvaF7sOAX01Nn2BQ";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "575307288-x4mJ3A3MxLHZbDmM4BqtkUsyzJrJe37xTbpB6XuH";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
