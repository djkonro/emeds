package com.emeds.android.emeds;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by konro on 7/29/16.
 */

public class EmedsListFragment extends Fragment{

    private RecyclerView mEmedsRecyclerView;
    private RvAdapter mAdapter;
    private List<String> strs;
    public static SQLiteDatabase db;
    public static String opt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emeds_list1, container, false);
        mEmedsRecyclerView = (RecyclerView) view.findViewById(R.id.emeds_recycler_view);
        mEmedsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        strs = new ArrayList<String>();

        strs.add(getString(R.string.hospitals));
        strs.add(getString(R.string.pharmacies));
        strs.add(getString(R.string.clinics));
        strs.add(getString(R.string.others));

        EmedsDbHelper mDbHelper = new EmedsDbHelper(getActivity().getApplicationContext());

        // Gets the data repository in write mode
        db = mDbHelper.getWritableDatabase();


        mAdapter = new RvAdapter(strs);
        mEmedsRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private class RvHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private ImageView mTitleImageView;
        private String str;

        public RvHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list1_item_service_text_view);
            mTitleImageView = (ImageView) itemView.findViewById(R.id.list1_item_service_image_view);
        }

        public void bindItem(String str) {
            this.str = str;
            mTitleTextView.setText(str);
            if(str == getString(R.string.hospitals)){
                mTitleImageView.setImageResource(R.mipmap.hospitals);
            }else if (str == getString(R.string.pharmacies)){
                mTitleImageView.setImageResource(R.mipmap.pharmacy);
            }else if (str == getString(R.string.clinics)){
                mTitleImageView.setImageResource(R.mipmap.clinics);
            }else if (str == getString(R.string.others)){
                mTitleImageView.setImageResource(R.mipmap.others);
            }
        }

        @Override
        public void onClick(View v) {
            opt = str;
            Intent intent = new Intent(getActivity(), EmedsItemListActivity.class);
            startActivity(intent);
        }
    }

    private class RvAdapter extends RecyclerView.Adapter<RvHolder> {

        private List<String> mstrs;

        public RvAdapter(List<String> strs) {
            mstrs = strs;
        }

        @Override
        public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list1_item_emeds, parent, false);
            return new RvHolder(view);
        }

        @Override
        public void onBindViewHolder(RvHolder holder, int position) {
            String str = mstrs.get(position);
            holder.bindItem(str);
        }

        @Override
        public int getItemCount() {
            return mstrs.size();
        }
    }
}
