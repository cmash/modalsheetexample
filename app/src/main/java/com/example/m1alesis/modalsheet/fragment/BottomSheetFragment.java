package com.example.m1alesis.modalsheet.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.m1alesis.modalsheet.R;

import java.util.HashMap;
import java.util.Map;

public class BottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            return;
        }
    };




    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.modal_sheet, null);
        dialog.setContentView(contentView);
        CoordinatorLayout.LayoutParams layoutParams =
                (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }

        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout) contentView.findViewById(R.id.gridlayoutView);
        /*Get all the view inside gridlayout*/
        LinearLayout layoutSelectable1 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable1);
        LinearLayout layoutSelectable2 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable2);
        LinearLayout layoutSelectable3 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable3);
        LinearLayout layoutSelectable4 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable4);
        LinearLayout layoutSelectable5 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable5);
        LinearLayout layoutSelectable6 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable6);
        LinearLayout layoutSelectable7 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable7);
        LinearLayout layoutSelectable8 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable8);
        LinearLayout layoutSelectable9 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable9);
        LinearLayout layoutSelectable10 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable10);
        LinearLayout layoutSelectable11 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable11);
        LinearLayout layoutSelectable12 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable13);
        LinearLayout layoutSelectable13 = (LinearLayout) contentView.findViewById(R.id.layoutSelectable13);

        /*Set on click listeners*/
        layoutSelectable1.setOnClickListener(this);
        layoutSelectable2.setOnClickListener(this);
        layoutSelectable3.setOnClickListener(this);
        layoutSelectable4.setOnClickListener(this);
        layoutSelectable5.setOnClickListener(this);
        layoutSelectable6.setOnClickListener(this);
        layoutSelectable7.setOnClickListener(this);
        layoutSelectable8.setOnClickListener(this);
        layoutSelectable9.setOnClickListener(this);
        layoutSelectable10.setOnClickListener(this);
        layoutSelectable11.setOnClickListener(this);
        layoutSelectable12.setOnClickListener(this);
        layoutSelectable13.setOnClickListener(this);

        /**
         * Hiding a layout in gridlayout will still occupy the space in UI.
         * Therefore removing the layout that are not required is the solution
         */
        Map<LinearLayout, String> map = new HashMap<LinearLayout, String >();
        /*Adding the default value*/
        map.put(layoutSelectable1, "show");
        map.put(layoutSelectable2, "show");
        map.put(layoutSelectable3, "show");
        map.put(layoutSelectable4, "show");
        map.put(layoutSelectable5, "show");
        map.put(layoutSelectable6, "show");
        map.put(layoutSelectable7, "show");
        map.put(layoutSelectable8, "show");
        map.put(layoutSelectable9, "show");
        map.put(layoutSelectable10, "show");
        map.put(layoutSelectable11, "show");
        map.put(layoutSelectable12, "show");
        map.put(layoutSelectable13, "show");


        /* and these are always visible */
        /**
         * Set layout valuey to "remove" if you dont want to show it.
         * eg. map.put(layoutSelectable13, "remove");
         */

        /*Remove views that we dont want*/
        for(Map.Entry<LinearLayout, String> entry : map.entrySet()){
            if(entry.getValue() == "remove"){
                gridLayout.removeView(entry.getKey());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutSelectable1:
                Toast.makeText(getActivity(), "first button pressed. do something!", Toast.LENGTH_SHORT).show();
                /*call dismiss() if you want to dismiss the bottom sheet at this point*/
                //dismiss();
                break;
            case R.id.layoutSelectable2:
                Toast.makeText(getActivity(), "second button pressed. do something!", Toast.LENGTH_SHORT).show();
                //dismiss();
                break;
            /*and so on ...*/
        }
    }
}
