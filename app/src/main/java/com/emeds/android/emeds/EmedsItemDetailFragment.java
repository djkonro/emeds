package com.emeds.android.emeds;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by konro on 8/8/16.
 */

public class EmedsItemDetailFragment extends Fragment{

    private TextView mTextView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emeds_detail, container, false);
        mTextView1 = (TextView) view.findViewById(R.id.detial_text_view1);

        Cursor cur = EmedsItemListFragment.scur;
        cur.moveToPosition(EmedsItemListFragment.spos);

        String str1 = cur.getString(
                cur.getColumnIndex(EmedsItemListFragment.columntitle));
        mTextView1.setText(str1);

        return view;
    }

}
