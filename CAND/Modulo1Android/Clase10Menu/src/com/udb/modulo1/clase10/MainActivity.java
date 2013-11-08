package com.udb.modulo1.clase10;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_new:
			Toast.makeText(this, "Selecciono Nuevo", Toast.LENGTH_LONG).show();
			return true;
		case R.id.action_settings:
			Toast.makeText(this, "Selecciono Configuracion", Toast.LENGTH_LONG).show();
			return true;
		case R.id.menucut:
			Toast.makeText(this, "Selecciono Cortar", Toast.LENGTH_LONG).show();
			return true;
		case R.id.menucopy:
			Toast.makeText(this, "Selecciono Copiar", Toast.LENGTH_LONG).show();
			return true;
		default:
			return true;
		}
	}
}
