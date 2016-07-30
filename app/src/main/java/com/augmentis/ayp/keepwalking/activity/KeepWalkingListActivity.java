package com.augmentis.ayp.keepwalking.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.DialogFragment.KeepWalkingDetailDialogFragment;
import com.augmentis.ayp.keepwalking.fragment.KeepWalkingListFragment;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingListActivity extends SingleFragmentOneButtonActivity {

    String buttonAddText = DefineValue.BUTTON_ADD;

    // TODO : create method for Intent newInstance

    @Override
    public String setButtonText() {
        return buttonAddText;
    }

    @Override
    public Fragment onCreateNewFragment() {
        return new KeepWalkingListFragment();
    }

    /**
     * onClick for Fragment
     * If button add is clicked go to KeepWalkingDetailActivity
     * KeepWalkingDetailActivity will show KeepWalkingDetailFragment in it's layout
     * @param view
     */
//    @Override
//    public void onClick(View view) {
//        Intent intent = KeepWalkingDetailActivity.newIntent(KeepWalkingListActivity.this, null);
//        startActivity(intent);
//    }

    /**
     * onClick for DialogFragment
     * @param view
     */
    @Override
    public void onClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        KeepWalkingDetailDialogFragment keepWalkingDetailDialogFragment =
                KeepWalkingDetailDialogFragment.newInstance(null);
        keepWalkingDetailDialogFragment.setTargetFragment(getFragment(), DefineValue.REQUEST_SAVE);
        keepWalkingDetailDialogFragment.show(fm, DefineValue.DIALOG_KEEP_WALKING_DETAIL);
    }


}