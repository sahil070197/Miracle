package gawds.nitkkr.com.miracle.UI.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gawds.nitkkr.com.miracle.R;
import gawds.nitkkr.com.miracle.Src.Callback;

/**
 * Created by SAHIL SINGLA on 14-01-2017.
 */
public class ReviewDialog
{
    private Dialog dialog;
    private String FeedbackTitle = "";
    private String FeedbackReview = "";

    public String getFeedbackReview()
    {
        return FeedbackReview;
    }

    public String getFeedbackTitle()
    {
        return FeedbackTitle;
    }

    public ReviewDialog(final Context context, String teacherName, final Callback callback)
    {
        dialog = new Dialog(context);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_feedback);

        ((TextView)dialog.findViewById(R.id.reviewTitle)).setText("Feedback: "+ teacherName);
        dialog.getWindow().getAttributes().windowAnimations = R.style.CloseDialogTheme;
        dialog.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FeedbackTitle=((EditText)dialog.findViewById(R.id.reviewTitle)).getText().toString().trim();
                FeedbackReview = ((EditText)dialog.findViewById(R.id.review)).getText().toString().trim();

                if(FeedbackTitle.isEmpty())
                {
                    Toast.makeText(context,"Provide Feedback Title",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(FeedbackReview.isEmpty())
                {
                    Toast.makeText(context,"Provide Feedback",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(callback!=null)
                    callback.onCallback();

                Dismiss();
            }
        });
        dialog.show();
    }
    public void Dismiss()
    {
        dialog.dismiss();
    }
}
