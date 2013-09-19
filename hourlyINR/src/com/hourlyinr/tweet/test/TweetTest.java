package com.hourlyinr.tweet.test;

import com.hourlyinr.json.JsonReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TweetTest {

	
	public static void main(String [] args){
		// The factory instance is re-useable and thread safe.
	    Twitter twitter = TwitterFactory.getSingleton();
	    Status status = null;
	    String strAccessToken = System.getProperty("twitter4j.oauth.accessToken");
	    String accessTokenSecret = System.getProperty("twitter4j.oauth.accessTokenSecret");
	    String strUpdate=args[0];
	    try {
        	
	    	try {
	    		strUpdate=JsonReader.getTweetString();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}

	    	System.out.println("strAccessToken="+strAccessToken);
			System.out.println("accessTokenSecret="+accessTokenSecret);
			
			/*
           AccessToken accesstoken = new AccessToken("1616373044-JBcEhjP2KysdqdEMQZlXi3C2tbti1zWQDwd1Jpw"
        			,"WZT2uGGRBORzyWqjQgezx9JDHAdkffhhgXbcypfJFY");
           */

			AccessToken accesstoken = new AccessToken(strAccessToken, accessTokenSecret);
            status = twitter.updateStatus(strUpdate);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");

			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");

	}
	
	
	
}
