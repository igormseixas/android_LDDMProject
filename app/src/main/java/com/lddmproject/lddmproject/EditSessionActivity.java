package com.lddmproject.lddmproject;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Created by Igor Machado Seixas on 9/24/2017.
 */

public class EditSessionActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //do some stuff for example write on log and update TextField on activity
        //Log.w("DatePicker","Date = " + year);
        //((EditText) findViewById(R.id.dateBegin)).setText("Date = " + year);
    }
}
