package com.example.rathana.alertdialog_demo.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rathana.alertdialog_demo.R;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Login");

        //custom body
        View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.login_custom_dialog,null);


        builder.setView(view);
        //footer

        //create edit object
        final EditText username=view.findViewById(R.id.username);
        final EditText password=view.findViewById(R.id.password);

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //call back
                Toast.makeText(getActivity(),
                        "User = "+username.getText().toString()+
                                "password =" +password.getText().toString(),
                        Toast.LENGTH_SHORT).show();
               dialog.dismiss();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}
