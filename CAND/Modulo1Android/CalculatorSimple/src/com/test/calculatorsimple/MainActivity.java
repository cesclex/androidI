package com.test.calculatorsimple;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

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
	public void calcular(View view){
    	EditText txtnum1 = (EditText) findViewById(R.id.edtNum1);
    	int total=0;
    	Integer num1 =Integer.parseInt(txtnum1.getText().toString());
    	EditText txtnum2 =(EditText) findViewById(R.id.edtNum2);
    	Integer num2 = Integer.parseInt(txtnum2.getText().toString());
    	//resolviendo que operacion se realizara
    	String operador ="";
    	RadioGroup grupo = (RadioGroup) findViewById(R.id.operaciones);
    	Integer idop= grupo.getCheckedRadioButtonId();
    	switch (idop) {
		case R.id.suma:
			operador="Suma";
			total=num1+num2;
			break;
		case R.id.resta:
			operador="Resta";
			total=num1-num2;
			break;
		case R.id.producto:
			operador="Multiplicación";
			total=num1*num2;
			break;
		case R.id.cociente:
			operador="División";
			total=num1/num2;
			break;
		default:
			operador="Nada";
			break;
		}
    	TextView resl=(TextView) findViewById(R.id.lblResult);
    	String tt=Integer.toString(total);
    	String  msjTotal= "La operación solicitada fue: "+operador+"\nEl total es: "+tt;
    	resl.setText(msjTotal);
    	
    }

}
