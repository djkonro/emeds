package com.emeds.android.emeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by konro on 7/31/16.
 */

public class EmedsItemListFragment extends Fragment {

    private RecyclerView mEmedsRecyclerView;
    private RvAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emeds_list, container, false);
        mEmedsRecyclerView = (RecyclerView) view.findViewById(R.id.emeds_recycler_view);
        mEmedsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> strs = new ArrayList<String>();

        strs.add("TEST1");
        strs.add("TEST2");
        strs.add("TEST3");
        strs.add("TEST4");

        mAdapter = new RvAdapter(strs);
        mEmedsRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private class RvHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private String str;

        public RvHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_service_text_view);
        }

        public void bindItem(String str) {
            this.str = str;
            mTitleTextView.setText(str);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), EmedsItemDetailActivity.class);
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
            View view = layoutInflater.inflate(R.layout.list_item_emeds, parent, false);
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
