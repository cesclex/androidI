package com.udb.modulo1.clase04;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoCompleteTextView actStates = (AutoCompleteTextView) findViewById(R.id.actdep);
		String [] states = getResources().getStringArray(R.array.departamentos);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,states);
		actStates.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage(View view){
		EditText edtEmail= (EditText) findViewById(R.id.edtcorreo);
		if(!emailValidator(edtEmail.getText().toString())){
			Toast.makeText(this, "Email Inv�lido", Toast.LENGTH_SHORT).show();
		}
	}
	
	//Validate mail
	public boolean emailValidator(String email){
		if(email != null){
			if(Build.VERSION.SDK_INT >= 8){
				return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

}
