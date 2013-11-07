package com.udb.modulo1.clase09;

import java.util.Calendar;

import com.udb.modulo1.clase09.fragments.DatePickerFragment;
import com.udb.modulo1.clase09.fragments.DatePickerFragment.DatePickedListener;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity implements  DatePickedListener{

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public void showDatepicker(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "Date Picker");
    }
	@Override
	public void onDatePicked(Calendar date) {
		// TODO Auto-generated method stub
		
	}

}
