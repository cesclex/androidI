package com.udb.modulo1.clase07;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void onClikOk(View view){
		RadioGroup radiog=(RadioGroup) findViewById(R.id.rdgOpciones);
		int selectItem=radiog.getCheckedRadioButtonId();
		if(selectItem==-1){
			Toast.makeText(this, "Debe seleccionar una opci�n para continuar", Toast.LENGTH_SHORT).show();
		}else{
			RadioButton decision=(RadioButton) findViewById(selectItem);
			Toast.makeText(this, decision.getText().toString(), Toast.LENGTH_SHORT).show();
		}
		
		
	}
	public void onRadioButtonClicked(View view){
		boolean checked =((RadioButton) view).isChecked();
		Toast.makeText(this, "La opci�n "+((RadioButton) view).getText().toString() + " esta "+checked, Toast.LENGTH_SHORT).show();
	}
}
