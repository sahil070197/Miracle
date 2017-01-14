package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import gawds.nitkkr.com.miracle.Helper.FeedAdapter;
import gawds.nitkkr.com.miracle.R;

public class ViewReviews extends AppCompatActivity {
    ListView feedListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reviews);
        //Activity to view reviews only for particular teacher

        //THIS CLASS IS FOR TEACHER SPECIFIC REVIEWS
        ArrayList<String> feedList=new ArrayList<>();
        feedListView=(ListView) findViewById(R.id.FeedList);
        FeedAdapter feedAdapter= new FeedAdapter(this,R.layout.feed_list_item,feedList);
        feedListView.setAdapter(feedAdapter);
    }
}
