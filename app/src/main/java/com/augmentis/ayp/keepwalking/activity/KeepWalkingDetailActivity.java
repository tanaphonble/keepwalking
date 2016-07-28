package com.augmentis.ayp.keepwalking.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.fragment.KeepWalkingDetailFragment;
import com.augmentis.ayp.keepwalking.item.Item;
import com.augmentis.ayp.keepwalking.item.Lab;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class KeepWalkingDetailActivity extends SingleFragmentOneButtonActivity {

    private UUID _itemId;
    private List<Item> _items = Lab.getInstance().getItems();

    String buttonSaveText = DefineValue.BUTTON_SAVE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _itemId = (UUID) getIntent().getSerializableExtra(DefineValue.ITEM_ID);
    }

    @Override
    public String setButtonText() {
        return buttonSaveText;
    }

    @Override
    public Fragment onCreateNewFragment() {
        UUID itemId = (UUID) getIntent().getSerializableExtra(DefineValue.ITEM_ID);
        Fragment keepWalkingDetailFragment = KeepWalkingDetailFragment.newInstance(itemId);
        return keepWalkingDetailFragment;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(KeepWalkingDetailActivity.this, KeepWalkingListActivity.class);
        startActivity(intent);
    }

    public static Intent newIntent(Context activity, UUID id) {
        Intent intent = new Intent(activity, KeepWalkingDetailActivity.class);
        if (id == null) {
            Item item = new Item();
            Lab.getInstance().getItems().add(item);
            intent.putExtra(DefineValue.ITEM_ID, item.getId());
        } else
            intent.putExtra(DefineValue.ITEM_ID, id);
        return intent;
    }
}
