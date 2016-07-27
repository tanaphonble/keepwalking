package com.augmentis.ayp.keepwalking.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.augmentis.ayp.keepwalking.R;

public abstract class SingleFragmentOneButtonActivity extends FragmentActivity implements View.OnClickListener {

    Button buttonOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment_one_button);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);
        buttonOne = (Button) findViewById(R.id.button_one);
        buttonOne.setText(setButtonText());
        buttonOne.setOnClickListener(this);

        // initialize fragment
        if (f == null){
            f = onCreateNewFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, f)
                    .commit();
        }
    }

    public abstract Fragment onCreateNewFragment();

    public abstract String setButtonText();
}