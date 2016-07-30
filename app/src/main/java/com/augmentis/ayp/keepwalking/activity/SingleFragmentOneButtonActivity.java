package com.augmentis.ayp.keepwalking.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.augmentis.ayp.keepwalking.R;

public abstract class SingleFragmentOneButtonActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonOne;
    Fragment f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment_one_button);

        FragmentManager fm = getSupportFragmentManager();
        f = fm.findFragmentById(R.id.fragment_container);
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

    public Fragment getFragment(){
        return f;
    }
}