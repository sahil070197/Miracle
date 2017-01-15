package gawds.nitkkr.com.miracle.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseCallback;
import gawds.nitkkr.com.miracle.API.ResponseStatus;
import gawds.nitkkr.com.miracle.Model.SubjectModel;
import gawds.nitkkr.com.miracle.R;

public class Notes extends Fragment
{
	private SubjectModel model = new SubjectModel();
	private Context context;
	ListView notes;

	public static Notes getInstance(Context context, SubjectModel model)
	{
		Notes notes=new Notes();
		notes.model=model;
		notes.context=context;
		return notes;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		View v= inflater.inflate(R.layout.fragment_notes, container, false);
		notes=(ListView) v.findViewById(R.id.FeedList);
		return v;
//		notes.setAdapter();
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		FetchData();
	}

	private void FetchData()
	{
		new FetchData().getNotes(model.getSubjectID(), new ResponseCallback()
		{
			@Override
			protected void onSuccess(Object object)
			{

			}

			@Override
			protected void onResponse(ResponseStatus status, Object object)
			{
				getView().findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
				if(status!=ResponseStatus.Success)
				{
					getView().findViewById(R.id.None).setVisibility(View.VISIBLE);
				}
			}
		});
	}
}
