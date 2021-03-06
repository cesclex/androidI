package com.udb.modulo1.clase04;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class Result_Activity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		// Show the Up button in the action bar.
		setupActionBar();
		Intent intent = getIntent();
		Bundle b = (Bundle) intent.getExtras();
		Data data =(Data) b.get(MainActivity.DATOS);
		
		TextView txtFirstName=(TextView) findViewById(R.id.txtfirstName);
		txtFirstName.setText(data.getFirstName());
		TextView txtLastName=(TextView) findViewById(R.id.txtlastName);
		txtLastName.setText(data.getLastName());
		TextView txtEmail=(TextView) findViewById(R.id.txtEmail);
		txtEmail.setText(data.getEmail());
		TextView txtDpto=(TextView) findViewById(R.id.txtDpto);
		txtDpto.setText(data.getDepartamento());
		TextView txtEdad=(TextView) findViewById(R.id.txtEdad);
		String edadTexto=Integer.toString(data.getEdad());
		txtEdad.setText(edadTexto);
		
		Button btnOk=(Button) findViewById(R.id.btnOk);
		btnOk.setOnClickListener(this);
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onClick(View view){
		try{
			switch (view.getId()) {
			case R.id.btnOk:
				EditText edtNote = (EditText) findViewById(R.id.edtNote);
				String note= edtNote.getText().toString();
				if(note.trim().equals("")){
					throw new Exception("Ingrese una nota v�lida");
				}
				Intent intent2= new Intent();
				intent2.putExtra("nota", note);
				setResult(RESULT_OK,intent2);
                finish();
				
				break;
			}
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}

}
