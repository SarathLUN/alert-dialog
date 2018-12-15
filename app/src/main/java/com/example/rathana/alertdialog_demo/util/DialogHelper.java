package com.example.rathana.alertdialog_demo.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.example.rathana.alertdialog_demo.R;

import java.util.ArrayList;
import java.util.List;

public class DialogHelper {

    private Context mContext;
    private AlertDialog.Builder dialogMessageBuilder;
    private int itemSelected=1;
    private CharSequence[] listItems={"iOS","Android","Windows","Black Berry","SyBien"};

    public DialogHelper(Context context){
        this.mContext=context;
        dialogMessageBuilder= new AlertDialog.Builder(mContext);
    }

    public void dialogMessage(String smg){
        //header
        dialogMessageBuilder.setIcon(R.mipmap.ic_launcher);
        dialogMessageBuilder.setTitle("Title");

        //body
        dialogMessageBuilder.setMessage(smg);

        //footer
        dialogMessageBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogMessageBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogMessageBuilder.setCancelable(false);
        /*AlertDialog dialog=dialogMessageBuilder.create();
        dialog.show();*/
        dialogMessageBuilder.create().show();
    }


    public void createSingleChoiceDialog(){
        dialogMessageBuilder.setTitle("Choose OS");
        dialogMessageBuilder.setIcon(R.mipmap.ic_launcher);

        dialogMessageBuilder.setItems(listItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, listItems[which], Toast.LENGTH_SHORT).show();
            }
        });

        dialogMessageBuilder.create().show();
    }

    public void createRadioButtonDialog(){
        dialogMessageBuilder.setTitle("Choose OS");
        dialogMessageBuilder.setIcon(R.mipmap.ic_launcher);

        dialogMessageBuilder.setSingleChoiceItems(listItems,
                itemSelected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                itemSelected=which;
                Toast.makeText(mContext, listItems[which], Toast.LENGTH_SHORT).show();
            }
        });
        dialogMessageBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogMessageBuilder.show();
    }


}
