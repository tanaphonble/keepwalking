package com.augmentis.ayp.keepwalking.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.fragment.KeepWalkingListFragment;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingListActivity extends SingleFragmentOneButtonActivity {

    String buttonAddText = DefineValue.BUTTON_ADD;

    @Override
    public String setButtonText() {
        return buttonAddText;
    }

    @Override
    public Fragment onCreateNewFragment() {
        return new KeepWalkingListFragment();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(KeepWalkingListActivity.this, KeepWalkingDetailActivity.class);
        startActivity(intent);
    }
}
