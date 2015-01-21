package com.example.ehi.mycalculator;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScreenFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_screen, container, false);
    }

    public void setDisplayText( String displayString){
        TextView textView = getTextViewFromScreenFragment();
        if (TextUtils.isEmpty(displayString)){
            textView.setText("0");
        } else {
            textView.setText(displayString);
        }
    }

    private TextView getTextViewFromScreenFragment() {
        return (TextView) getView().findViewById(R.id.textView);
    }

}
