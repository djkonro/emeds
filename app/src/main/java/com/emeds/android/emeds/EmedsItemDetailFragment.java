package com.emeds.android.emeds;

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


/**
 * Created by konro on 8/8/16.
 */

public class EmedsItemDetailFragment extends Fragment{

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private ImageView mTitleImageView;
    private RecyclerView mEmedsRecyclerView;
    private List<String> strs;
    private RvAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emeds_detail, container, false);
        mEmedsRecyclerView = (RecyclerView) view.findViewById(R.id.service_recycler_view);
        mEmedsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mTextView1 = (TextView) view.findViewById(R.id.itemname);
        mTextView2 = (TextView) view.findViewById(R.id.number);
        mTextView3 = (TextView) view.findViewById(R.id.address);
        mTitleImageView = (ImageView) view.findViewById(R.id.card_image);

        Cursor cur = EmedsItemListFragment.scur;
        cur.moveToPosition(EmedsItemListFragment.spos);

        String id = cur.getString(
                cur.getColumnIndex(EmedsDb.ENTRY_ID));
        id = id.toLowerCase();
        String name = cur.getString(
                cur.getColumnIndex(EmedsDb.NAME));
        String phone = cur.getString(
                cur.getColumnIndex(EmedsDb.PHONE));
        String location = cur.getString(
                cur.getColumnIndex(EmedsDb.LOCATION));

        mTextView1.setText(name);
        mTextView2.setText("+237"+phone);
        mTextView3.setText(location);
        int resID = getResources().getIdentifier(id , "drawable", getActivity().getPackageName());
        if(resID <= 0)
            resID = getResources().getIdentifier("test" , "drawable", getActivity().getPackageName());
        mTitleImageView.setImageResource(resID);

        strs = new ArrayList<String>();

        strs.add("Pharmacy");
        strs.add("Echography");
        strs.add("Laboratory");
        strs.add("Medical Unit");
        strs.add("Theatre");
        strs.add("Surgical Unit");
        strs.add("Maternity");

        mAdapter = new EmedsItemDetailFragment.RvAdapter(strs);
        mEmedsRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private class RvHolder extends RecyclerView.ViewHolder{

        private TextView mTitleTextView;

        public RvHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.service_item_text_view);
        }

        public void bindItem(String str) {
            mTitleTextView.setText(str);
        }
    }

    private class RvAdapter extends RecyclerView.Adapter<EmedsItemDetailFragment.RvHolder> {

        private List<String> mstrs;

        public RvAdapter(List<String> strs) {
            mstrs = strs;
        }

        @Override
        public EmedsItemDetailFragment.RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.service_list_emeds, parent, false);
            return new EmedsItemDetailFragment.RvHolder(view);
        }

        @Override
        public void onBindViewHolder(EmedsItemDetailFragment.RvHolder holder, int position) {
            String str = mstrs.get(position);
            holder.bindItem(str);
        }

        @Override
        public int getItemCount() {
            return mstrs.size();
        }
    }

}
