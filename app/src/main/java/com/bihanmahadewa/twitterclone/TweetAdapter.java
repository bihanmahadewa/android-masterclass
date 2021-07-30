package com.bihanmahadewa.twitterclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.MyTweetHolder> {

    private Context context;
    private List<Tweet> tweetList;

    public TweetAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweetList = tweets;
    }

    @NonNull
    @Override
    public MyTweetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new MyTweetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTweetHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.txtDisplayName.setText(tweet.getDisplayName());
        holder.txtUsername.setText("@"+tweet.getUsername());
        holder.txtTweet.setText(tweet.getTweet());
        holder.txtTimePublished.setText(tweet.getPublishedTime());
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class MyTweetHolder extends RecyclerView.ViewHolder{
        public TextView txtDisplayName;
        public TextView txtUsername;
        public TextView txtTweet;
        public TextView txtTimePublished;

        public MyTweetHolder(View v){
            super(v);
            txtDisplayName = v.findViewById(R.id.txt_display_name);
            txtUsername = v.findViewById(R.id.txt_username);
            txtTweet = v.findViewById(R.id.txt_tweet);
            txtTimePublished = v.findViewById(R.id.txt_time);
        }
    }
}
