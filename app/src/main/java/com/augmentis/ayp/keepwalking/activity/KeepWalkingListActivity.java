package com.augmentis.ayp.keepwalking.activity;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.fragment.KeepWalkingListFragment;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingListActivity extends SingleFragmentOneButtonActivity {

    @Override
    public Fragment onCreateNewFragment() {
        return new KeepWalkingListFragment();
    }

    @Override
    public void onClick(View view) {

    }
}
