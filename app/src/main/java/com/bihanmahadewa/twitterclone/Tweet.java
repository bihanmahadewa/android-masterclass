package com.bihanmahadewa.twitterclone;

public class Tweet {
    private String username;
    private String displayName;
    private String tweet;
    private String publishedTime;

    public Tweet(String username, String displayName, String tweet, String publishedTime){
        setUsername(username);
        setDisplayName(displayName);
        setTweet(tweet);
        setPublishedTime(publishedTime);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }
}
