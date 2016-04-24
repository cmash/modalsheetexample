package com.example.m1alesis.modalsheet.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.m1alesis.modalsheet.R;
import com.example.m1alesis.modalsheet.fragment.BottomSheetFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sheetTriggerBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Set up button*/
        sheetTriggerBtn = (Button) findViewById(R.id.triggerModal);
        sheetTriggerBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            /*OnClick triggerModal button*/
            case R.id.triggerModal:
                //Initializing a bottom sheet
                BottomSheetFragment bottomSheetDialogFragment = new BottomSheetFragment();

                //show it
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                break;
        }
    }
}
