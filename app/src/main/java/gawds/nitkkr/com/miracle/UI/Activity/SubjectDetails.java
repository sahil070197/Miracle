package gawds.nitkkr.com.miracle.UI.Activity;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseCallback;
import gawds.nitkkr.com.miracle.API.ResponseStatus;
import gawds.nitkkr.com.miracle.Helper.ActionBarBack;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.SubjectModel;
import gawds.nitkkr.com.miracle.Model.UserModel;
import gawds.nitkkr.com.miracle.R;
import gawds.nitkkr.com.miracle.Src.Callback;
import gawds.nitkkr.com.miracle.UI.Adapter.ViewPagerAdapter;
import gawds.nitkkr.com.miracle.UI.Dialog.ReviewDialog;
import gawds.nitkkr.com.miracle.UI.Fragment.Attendance;
import gawds.nitkkr.com.miracle.UI.Fragment.Notes;
import gawds.nitkkr.com.miracle.UI.Fragment.Result;

public class SubjectDetails extends AppCompatActivity
{
    private ReviewDialog dialog = null;
    private ActionBarBack actionBarBack;
    private ViewPagerAdapter adapter;
    private SubjectModel model = new SubjectModel();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        ActivityHelper.setCreateAnimation(this);

        try
        {
            model = (SubjectModel) getIntent().getExtras().getSerializable("Subject");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model = new SubjectModel();
        }

        actionBarBack=new ActionBarBack(this);
        actionBarBack.setLabel(model.getName());

        findViewById(R.id.review).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog=new ReviewDialog(SubjectDetails.this, model.getTeachername(), new Callback()
                {
                    @Override
                    public void onCallback()
                    {
                        String title =dialog.getFeedbackTitle();
                        String Feedback = dialog.getFeedbackReview();

                        final ProgressDialog dialog= new ProgressDialog(SubjectDetails.this);
                        dialog.setIndeterminate(true);
                        dialog.setCancelable(false);
                        dialog.setMessage("Submitting Review");
                        dialog.show();

                        new FetchData().sendReview(model.getTeacherID(),title,Feedback,new ResponseCallback()
                        {
                            @Override
                            public void onResponse(ResponseStatus responseStatus, Object object)
                            {
                                dialog.dismiss();
                            }

                            @Override
                            public void onFailed(Object object)
                            {
                                Toast.makeText(SubjectDetails.this,"Review Submission Failed",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onSuccess(Object object)
                            {
                                Toast.makeText(SubjectDetails.this,"Review Submitted Successfully",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                dialog.show();
            }
        });

        final ProgressDialog dialog= new ProgressDialog(SubjectDetails.this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Logging In");
        dialog.show();

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(Attendance.getInstance(SubjectDetails.this,model),"Attendance");
        adapter.addFragment(Notes.getInstance(SubjectDetails.this,model),"Notes");
        adapter.addFragment(Result.getInstance(SubjectDetails.this,model),"Results");

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        tabLayout.setupWithViewPager(viewPager,true);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        new FetchData().getSubjectDetails("==Some ID==",new ResponseCallback()
        {
            @Override
            protected void onResponse(ResponseStatus status, Object object)
            {
                dialog.dismiss();
                if(status!=ResponseStatus.Success)
                {
                    finish();
                    ActivityHelper.setExitAnimation(SubjectDetails.this);
                }
            }

            @Override
            protected void onFailed(Object object)
            {
                Toast.makeText(getApplicationContext(),"Failed to Fetch Subject Details",Toast.LENGTH_LONG).show();
            }

            @Override
            protected void onSuccess(Object object)
            {
                setupContent();
            }
        });
    }

    public void setupContent()
    {
        actionBarBack.setLabel("Subject Loaded");
    }

}
