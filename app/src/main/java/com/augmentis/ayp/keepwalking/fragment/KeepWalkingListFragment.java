package com.augmentis.ayp.keepwalking.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.augmentis.ayp.keepwalking.R;
import com.augmentis.ayp.keepwalking.activity.KeepWalkingDetailActivity;
import com.augmentis.ayp.keepwalking.item.Item;
import com.augmentis.ayp.keepwalking.item.Lab;


import java.util.List;


/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingListFragment extends Fragment {

    private RecyclerView _recyclerView;
    private ItemAdapter _itemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keep_walking_recycler_view, container, false);
        _recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_keep_walking);
        _recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        Lab lab = Lab.getInstance();
        List<Item> items = lab.getItems();
        if (_itemAdapter == null) {
            _itemAdapter = new ItemAdapter(items);
            _recyclerView.setAdapter(_itemAdapter);
        } else {
            _itemAdapter.notifyAll();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView _textViewTitle;
        private TextView _textViewTimeStamp;

        Item _item;

        @Override
        public void onClick(View view) {
            Intent intent = KeepWalkingDetailActivity.newIntent(getActivity(), _item.getId());
            startActivity(intent);
        }

        public ItemHolder(View itemView) {
            super(itemView);
            _textViewTitle = (TextView) itemView.findViewById(R.id.text_view_title);
            _textViewTimeStamp = (TextView) itemView.findViewById(R.id.text_view_time_stamp);
            itemView.setOnClickListener(this);
        }

        public void bind(Item item) {
            _item = item;
            _textViewTitle.setText(_item.getTitle());
            _textViewTimeStamp.setText(item.getTimeStamp());
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<Item> _items;

        public ItemAdapter(List<Item> items) {
            _items = items;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.fragment_item_holder, parent, false);
            return new ItemHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            Item item = _items.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return _items.size();
        }
    }
}
