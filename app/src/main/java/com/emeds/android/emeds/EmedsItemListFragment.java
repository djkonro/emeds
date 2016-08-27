package com.emeds.android.emeds;

import android.content.Intent;
import android.database.Cursor;
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

import static com.emeds.android.emeds.EmedsListFragment.opt;

/**
 * Created by konro on 7/31/16.
 */

public class EmedsItemListFragment extends Fragment {

    private RecyclerView mEmedsRecyclerView;
    private RvAdapter mAdapter;
    public static String tablename = null, columntitle = null;
    public static int spos;
    public static Cursor scur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emeds_list2, container, false);
        mEmedsRecyclerView = (RecyclerView) view.findViewById(R.id.emeds_recycler_view);
        mEmedsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Integer> curs = new ArrayList<Integer>();

        if(EmedsListFragment.opt == getString(R.string.hospitals)){
            tablename = EmedsDb.HospitalEntry.TABLE_NAME;
            columntitle = EmedsDb.HospitalEntry.COLUMN_NAME_TITLE;
        }else if (EmedsListFragment.opt == getString(R.string.pharmacies)){
            tablename = EmedsDb.PharmacyEntry.TABLE_NAME;
            columntitle = EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE;
        }else if (EmedsListFragment.opt == getString(R.string.clinics)){
            tablename = EmedsDb.ClinicEntry.TABLE_NAME;
            columntitle = EmedsDb.ClinicEntry.COLUMN_NAME_TITLE;
        }


        //mTitleImageView.setImageResource(R.mipmap.hospitals);
        Cursor cursor = EmedsDb.getCursor(tablename);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                curs.add(cursor.getPosition());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        mAdapter = new RvAdapter(curs);
        mEmedsRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private class RvHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private ImageView mTitleImageView;
        private String str;
        private int cur;
        private Cursor cursor = EmedsDb.getCursor(tablename);

        public RvHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list2_item_service_text_view);
            mTitleImageView = (ImageView) itemView.findViewById(R.id.list2_item_service_image_view);
        }

        public void bindItem(Integer cur) {
            this.cur = cur;
            cursor.moveToPosition(cur);
            str = cursor.getString(
                    cursor.getColumnIndex(columntitle));
            //cursor.close();
            mTitleImageView.setImageResource(R.drawable.test);
            mTitleTextView.setText(str);
        }

        @Override
        public void onClick(View v) {
            spos = cur;
            scur = cursor;
            Intent intent = new Intent(getActivity(), EmedsItemDetailActivity.class);
            startActivity(intent);
        }
    }

    private class RvAdapter extends RecyclerView.Adapter<RvHolder> {

        private List<Integer> mcurs;

        public RvAdapter(List<Integer> curs) {
            mcurs = curs;
        }

        @Override
        public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list2_item_emeds, parent, false);
            return new RvHolder(view);
        }

        @Override
        public void onBindViewHolder(RvHolder holder, int position) {
            Integer cur = mcurs.get(position);
            holder.bindItem(cur);
        }

        @Override
        public int getItemCount() {
            return mcurs.size();
        }
    }
}