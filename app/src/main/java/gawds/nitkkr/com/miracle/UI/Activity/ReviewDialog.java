package gawds.nitkkr.com.miracle.UI.Activity;

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

import gawds.nitkkr.com.miracle.R;

/**
 * Created by SAHIL SINGLA on 14-01-2017.
 */
public class ReviewDialog extends Dialog implements View.OnClickListener {
    public ReviewDialog(Context context) {
        super(context);
    }
    private Button submit;
    private TextView header;
    private EditText title,review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        submit=(Button) findViewById(R.id.submit);
        header=(EditText) findViewById(R.id.reviewTitle);
        review=(EditText) findViewById(R.id.review);
        header=(TextView) findViewById(R.id.teacherName);

        // set teacher name to header
        header.setText("Review for "/*Teacher Name Here*/);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new AlertDialog.Builder(getContext())
                .setMessage("Any offensive reviews would be strictly treated! Do you really want to submit?")
                .setTitle("Warning!")
                .setNegativeButton("No", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Nothing
                    }
                })
                //.setIcon()
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title=header.getText().toString();
                        String reviewText=review.getText().toString();
                        //send these reviews and dismiss
                    }
                })
                .show();
    }
}
