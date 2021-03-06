package com.udb.clase09.altform;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private TimePicker timePicker1;
	private Button btnChangeTime;
 
	private int hour;
	private int minute;
 
	static final int TIME_DIALOG_ID = 999;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
		 
		final Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);

		timePicker1.setCurrentHour(hour);
		timePicker1.setCurrentMinute(minute);
		timePicker1.setEnabled(false);
		
		btnChangeTime = (Button) findViewById(R.id.btnChangeTime);
		btnChangeTime.setOnClickListener(new OnClickListener() {
 
			@SuppressWarnings("deprecation")
			@Override	
			public void onClick(View v) {
 
				showDialog(TIME_DIALOG_ID);
			}
 
		});
 
	}
 
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			// set time picker as current time
			return new TimePickerDialog(this, timePickerListener, hour, minute,false);
 
		}
		return null;
	}
 
	private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;
			// set current time into timepicker
			timePicker1.setCurrentHour(hour);
			timePicker1.setCurrentMinute(minute);
 
		}
	};

}
