package com.udb.modulo1clase03;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String tag="Clase 03";
	public final static String EXTRA_MESSAGE="com.udb.modulo1clase03.MESSAGE";
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
    //FUNCION PARA BOTON
    public void sendMessage(View view){
    	Log.i(tag, "Click en sendMessage");
    	EditText edtMensaje = (EditText) findViewById(R.id.edtMessage);
    	String message = edtMensaje.getText().toString();
    	Intent intent = new Intent(this,ResultActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
}
