package com.udb.modulo1.clase22;

import com.udb.modulo1.clase22.sqlite.SQLliteHelper;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{

	public static final String STUDENT_KEY = "com.udb.modulo1.clase25.STUDENT";
	public static final String STUDENT_MTO = "com.udb.modulo1.clase25.STUDENTMTO";
	SQLiteDatabase db =null;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listViewStudent);
		listView.setOnItemClickListener(this);
		initDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void initDatabase(){
		try{
			SQLliteHelper sqliteHelper = new SQLliteHelper(this, "university.db", null, 1);
			db = sqliteHelper.getWritableDatabase();
			loadListView();
			db.close();
		}catch(SQLException sqlerror){	
			Toast.makeText(this, "DB: "+sqlerror.getMessage(), Toast.LENGTH_LONG).show();
		    sqlerror.printStackTrace();
		}catch(Exception e){
			Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void loadListView() throws Exception{
		//String[] columns = {"code","name","age"};
		//Cursor cursor = db.query("students", columns, null, null, null, null, null);
		// rowid _id = Simula un id de la fila para la BD
		//Se toman los datos en el cursor y luego guardarlos en una coleccion de objetos(Array) con estructura JSON
		//luego se establecen en estructura de Json los campos que se utlizaran para mostrar la informacion
		//Se adapta la informacion a un listview
		Cursor cursor = db.rawQuery("select rowid _id,code, name, age from students", null);
		String[] from = {"code","name","age"};
		int[] to = {R.id.txtId,R.id.textCod,R.id.textView2};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.student_layout, cursor, from, to,0);
		listView.setAdapter(adapter);
	}
	
	
	
	@Override
	public void onItemClick(AdapterView<?> listview, View view, int position, long id) {
		try{
			Bundle b = new Bundle();				
			Intent intent = new Intent(this, Manto_student.class);
			Cursor cursor = (Cursor) listview.getItemAtPosition(position);
			StudentBean bean = new StudentBean();
			bean.setId(cursor.getInt(1));
			bean.setName(cursor.getString(2));
			bean.setAge(cursor.getInt(3));
			b.putSerializable(STUDENT_KEY, bean);
			intent.putExtras(b);
			intent.putExtra(STUDENT_MTO, "MTO");
			startActivityForResult(intent,2);
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		
	}

	@Override
	public void onActivityResult(int inputCode, int resultCode, Intent intent2){
		if(resultCode==RESULT_OK){
			initDatabase();
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_mto:
			Intent intent = new Intent(this, Manto_student.class);
			intent.putExtra(STUDENT_MTO, "NVO");
			startActivityForResult(intent, 1);
			return true;
		case R.id.action_settings:
			Toast.makeText(this, "Selecciono Configuracion", Toast.LENGTH_LONG).show();
			return true;
		default:
			return true;
		}
	}

}
