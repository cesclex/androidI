package com.udb.modulo1.clase04;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String DATOS="com.udb.modulo1.clase04.DATOS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoCompleteTextView actStates = (AutoCompleteTextView) findViewById(R.id.actdep);
		String [] states = getResources().getStringArray(R.array.departamentos);
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,states);	*/
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.autocomplete_item,states);
		actStates.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage(View view){
		try{
			EditText edtEmail= (EditText) findViewById(R.id.edtcorreo);
			if(!emailValidator(edtEmail.getText().toString())){
				//Toast.makeText(this, "Email Inv�lido", Toast.LENGTH_SHORT).show();
				throw new Exception("Error email Inv�lido");	
			}
			Data data = new Data();
			//cajas normales
			data.setFirstName((((EditText) findViewById(R.id.edtfirstname)).getText()).toString());
			data.setLastName((((EditText) findViewById(R.id.edtlastname)).getText()).toString());
			data.setEmail((((EditText) findViewById(R.id.edtcorreo)).getText()).toString());
			//autocomplementar valor
			AutoCompleteTextView actState=(AutoCompleteTextView) findViewById(R.id.actdep);
			data.setDepartamento(actState.getText().toString());
			
			EditText edtAge=(EditText) findViewById(R.id.edtedad);
			int age = Integer.parseInt(edtAge.getText().toString());
			data.setEdad(age);
			
			Bundle b = new Bundle();
			b.putSerializable(DATOS, data);
			Intent intent = new Intent(this,Result_Activity.class); 
			intent.putExtras(b);
			int inputCode=17;
			startActivityForResult(intent,inputCode);
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode==RESULT_OK){
			Toast.makeText(this, "Bienvenido !!!", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Lastima :(", Toast.LENGTH_SHORT).show();
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
