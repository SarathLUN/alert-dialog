package com.example.rathana.alertdialog_demo.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceDialogFragment extends DialogFragment {

     static CharSequence[] listItems={"iOS","Android","Windows","Black Berry","SyBien"};
    List<CharSequence> itemSelected=new ArrayList<>();
    static boolean[] isItemsChecked;

    static {
        isItemsChecked=new boolean[listItems.length];
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        itemSelected.add(listItems[0]);
        isItemsChecked[0]=true;
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog Fragment");

        builder.setMultiChoiceItems(
                listItems,
                isItemsChecked,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which, boolean isChecked) {
                        if(isChecked){
                            itemSelected.add(listItems[which]);
                            isItemsChecked[which]=true;
                        } else{
                            itemSelected.remove(listItems[which]);
                            isItemsChecked[which]=false;
                        }

                    }
                }
        );
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onSendItemsList(itemSelected);
                dialog.dismiss();
            }
        });

        return  builder.create();
    }

    public interface OnSendData{
        void onSendItemsList(List<CharSequence> items);
    }

    //create call back object;
    private OnSendData listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener= (OnSendData) context;
    }
}
