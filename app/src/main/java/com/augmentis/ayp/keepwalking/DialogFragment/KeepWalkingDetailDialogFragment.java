package com.augmentis.ayp.keepwalking.DialogFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.augmentis.ayp.keepwalking.DefineValue;
import com.augmentis.ayp.keepwalking.R;
import com.augmentis.ayp.keepwalking.item.Item;
import com.augmentis.ayp.keepwalking.item.Lab;

import java.util.UUID;

/**
 * Created by Tanaphon on 7/29/2016.
 */
public class KeepWalkingDetailDialogFragment extends DialogFragment {

    EditText _editTextKeepWalkingDetail;
    private boolean isNewItem;
    private UUID _item_id;
    private Item _new_item;
    private Item _item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isNewItem = getArguments().getBoolean(DefineValue.IS_NEW_ITEM);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_keep_walking_detail, null);
        _editTextKeepWalkingDetail = (EditText) v.findViewById(R.id.edit_text_title);
        _editTextKeepWalkingDetail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                _item.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (!isNewItem) {
            _item_id = (UUID) getArguments().getSerializable(DefineValue.ITEM_ID);
            _item = Lab.getInstance().getItemById(_item_id);
            _editTextKeepWalkingDetail.setText(_item.getTitle());
        } else {
            _new_item = new Item();
            _item = _new_item;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setTitle(R.string.keep_walking_detail_dialog_title);

        // Button Save
        builder.setPositiveButton(R.string.button_save_keep_walking_detail, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Lab.getInstance().getItems().add(_new_item);
                        if (getTargetFragment() == null) {
                            return;
                        }
                        Intent intent = new Intent();
                        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);

                    }
                }

        );
        return builder.create();
    }


    public static KeepWalkingDetailDialogFragment newInstance(UUID id) {
        KeepWalkingDetailDialogFragment keepWalkingDetailDialogFragment = new KeepWalkingDetailDialogFragment();
        Bundle arguments = new Bundle();
        if (id == null)
            arguments.putBoolean(DefineValue.IS_NEW_ITEM, true);
        else {
            arguments.putBoolean(DefineValue.IS_NEW_ITEM, false);
            arguments.putSerializable(DefineValue.ITEM_ID, id);
        }
        keepWalkingDetailDialogFragment.setArguments(arguments);
        return keepWalkingDetailDialogFragment;
    }
}