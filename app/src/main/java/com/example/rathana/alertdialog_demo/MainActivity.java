package com.example.rathana.alertdialog_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.alertdialog_demo.util.CustomDialogFragment;
import com.example.rathana.alertdialog_demo.util.DialogHelper;
import com.example.rathana.alertdialog_demo.util.MultipleChoiceDialogFragment;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.List;

public class MainActivity extends AppCompatActivity
implements MultipleChoiceDialogFragment.OnSendData {

    TextView textResult;
    DialogHelper dialogHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult=findViewById(R.id.textResult);

        dialogHelper=new DialogHelper(this);

        dialogHelper.dialogMessage(
                "Thanks for download this app.");


    }

    public void onShowListDialog(View view) {
        dialogHelper.createSingleChoiceDialog();
    }

    public void onShowRadioDialog(View view) {
        dialogHelper.createRadioButtonDialog();
    }

    public void onShowCheckboxDialog(View view) {

        //dialogHelper.multipleChoiceListDialog();
        new MultipleChoiceDialogFragment()
                .show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public void onSendItemsList(List<CharSequence> items) {
        textResult.setText(items.toString());
    }

    public void onShowCustomDialog(View view) {
        new CustomDialogFragment().show(getSupportFragmentManager(),"custom dialog");
    }

    public void onShowFancyGifDialog(View view) {

        new FancyGifDialog.Builder(this)
                .setTitle("Third party dependency")
                .setMessage("your message here!")
                .setNegativeBtnBackground("#FF4081")
                .setPositiveBtnBackground("#FF4081")
                .setGifResource(R.drawable.tom)
                .setPositiveBtnText("OK")
                .setNegativeBtnText("Cancel")
        .OnPositiveClicked(new FancyGifDialogListener(){
            @Override
            public void OnClick() {
                Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show();

            }})
        .OnNegativeClicked(new FancyGifDialogListener() {
            @Override
            public void OnClick() {

            }
        }).build();
    }
}
