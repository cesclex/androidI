package com.udb.modulo1.clase19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edtText;
	TextView txtRead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtText = (EditText) findViewById(R.id.saveInfo);
		txtRead = (TextView) findViewById(R.id.fileinfo);
		readFile();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void saveInfo(View view) {
		String eol = System.getProperty("line.separator");
		try {
			FileOutputStream fos = openFileOutput("internalfile", MODE_PRIVATE);
						
			String filesave = txtRead.getText().toString()+edtText.getText().toString() + eol;
			fos.write(filesave.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		edtText.setText("");
		Toast.makeText(this, "Informacion Guardada", Toast.LENGTH_SHORT).show();
	}
	
	public void readInfo(View view){
		readFile();
	}
	
	public void cleanFile(View view){
		deleteFile("internalfile");
		edtText.setText("");
		txtRead.setText("");
	}
	
	public void readFile(){
		String eol = System.getProperty("line.separator");
		BufferedReader input = null;
		try {
			
			
			input = new BufferedReader(new InputStreamReader(openFileInput("internalfile")));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = input.readLine()) != null) {
				buffer.append(line + eol);
			}
			
			File file = getFilesDir();
			
			txtRead.setText("Dir:"+file.getAbsolutePath()+"\n"+buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
