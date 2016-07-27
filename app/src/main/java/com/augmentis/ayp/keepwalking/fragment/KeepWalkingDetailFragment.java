package com.augmentis.ayp.keepwalking.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.R;
import com.augmentis.ayp.keepwalking.item.Item;
import com.augmentis.ayp.keepwalking.item.Lab;

import java.util.UUID;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingDetailFragment extends Fragment {

    EditText editTextTitle;
    Item item;

    public static KeepWalkingDetailFragment newInstance(UUID itemId){
        Bundle args = new Bundle();
        args.putSerializable(DefineValue.ITEM_ID, itemId);
        KeepWalkingDetailFragment keepWalkingDetailFragment = new KeepWalkingDetailFragment();
        keepWalkingDetailFragment.setArguments(args);
        return keepWalkingDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getArguments().getSerializable(DefineValue.ITEM_ID);
        item = Lab.getInstance().getItemById(itemId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keep_walking_detail, container, false);
        editTextTitle = (EditText) v.findViewById(R.id.edit_text_title);
        editTextTitle.setText(item.getTitle());
        editTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return v;
    }

}
