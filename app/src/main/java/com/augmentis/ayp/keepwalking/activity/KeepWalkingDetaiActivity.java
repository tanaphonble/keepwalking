package com.augmentis.ayp.keepwalking.activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.augmentis.ayp.keepwalking.fragment.KeepWalkingDetailFragment;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingDetaiActivity extends SingleFragmentOneButtonActivity {
    @Override
    public Fragment onCreateNewFragment() {
        return new KeepWalkingDetailFragment();
    }


    @Override
    public void onClick(View view) {

    }
}
