package com.example.rathana.alertdialog_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rathana.alertdialog_demo.util.DialogHelper;

public class MainActivity extends AppCompatActivity {

    DialogHelper dialogHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogHelper=new DialogHelper(this);

        /*dialogHelper.dialogMessage(
                "Thanks for download this app.");*/
    }

    public void onShowListDialog(View view) {
        dialogHelper.createSingleChoiceDialog();
    }

    public void onShowRadioDialog(View view) {
        dialogHelper.createRadioButtonDialog();
    }
}
