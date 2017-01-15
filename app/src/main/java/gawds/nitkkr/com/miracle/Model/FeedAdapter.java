package gawds.nitkkr.com.miracle.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import gawds.nitkkr.com.miracle.R;

/**
 * Created by SAHIL SINGLA on 15-01-2017.
 */
public class FeedAdapter extends ArrayAdapter<String>{
    public FeedAdapter(Context context, int textViewResourceId){
        super(context,textViewResourceId);
    }
    public FeedAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v==null)
        {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.feed_list_item,null);
        }
        String student=getItem(position);
        if(student!= null)
        {
            TextView name=(TextView) v.findViewById(R.id.feedtitle);
            name.setText(student);
            TextView present=(TextView) v.findViewById(R.id.sender);
        }
        return  v;
    }
}
