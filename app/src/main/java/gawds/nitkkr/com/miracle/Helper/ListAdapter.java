package gawds.nitkkr.com.miracle.Helper;

import android.content.ClipData;
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
 * Created by SAHIL SINGLA on 14-01-2017.
 */
public class ListAdapter extends ArrayAdapter<String> {
    public ListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v==null)
        {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.attendance_list_item,null);
        }
        String student=getItem(position);
        if(student!= null)
        {
            TextView name=(TextView) v.findViewById(R.id.name);
            name.setText(student);
            Switch present=(Switch) v.findViewById(R.id.present);
            present.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.v("State",""+b);
                }
            });
        }
        return  v;
    }
}
