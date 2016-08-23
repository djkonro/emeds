package com.emeds.android.emeds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EmedsItemDetailActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        Rlayoutid = R.layout.activity_emeds;
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new EmedsItemDetailFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }

    /**
     * This method is use to place a call from the call button on the detail activity
     * @param v
     */
    public void makeCall(View v){

        //find the number textview
        TextView numberTextView = (TextView)findViewById(R.id.number);

        //get the phone and number and make the call
        String number = numberTextView.getText().toString();

        Toast.makeText(this.getApplicationContext(), "Calling "+number, Toast.LENGTH_SHORT).show();

        //now placing the call
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);

    }

}
