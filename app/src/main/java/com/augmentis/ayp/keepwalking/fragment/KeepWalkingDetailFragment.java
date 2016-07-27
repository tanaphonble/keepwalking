package com.augmentis.ayp.keepwalking.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.augmentis.ayp.keepwalking.R;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingDetailFragment extends Fragment {

    EditText editTextTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keep_walking_detail, container, false);
        editTextTitle = (EditText) v.findViewById(R.id.edit_text_title);
        return v;
    }
}
