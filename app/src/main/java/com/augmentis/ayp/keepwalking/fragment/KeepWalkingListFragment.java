package com.augmentis.ayp.keepwalking.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.augmentis.ayp.keepwalking.R;


/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingListFragment extends Fragment {

    private RecyclerView _recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keep_walking_recycler_view, container, false);
        _recyclerView = (RecyclerView) v.findViewById(R.id.keep_walking_recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
}
