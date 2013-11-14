package com.udb.modulo1.clase18;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

	WebView webSide1, webSide2;
	String html1, html2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webSide1 = (WebView) findViewById(R.id.webSide1);
		webSide2 = (WebView) findViewById(R.id.webSide2);
		
		WebSettings webSetting1 = webSide1.getSettings();
		webSetting1.setBuiltInZoomControls(true);
		
		WebSettings webSetting2 = webSide2.getSettings();
		webSetting2.setBuiltInZoomControls(true);
		webSetting2.setUseWideViewPort(true);
		
		webSetting1.setDefaultTextEncodingName("utf-8");
		html1 = "<h1><font size=4 color=\"#CC0000\">Mostrando imagenes locales</font></h1>"+
		"<b>Ejemplo de uso de HTML en Android</b><br />";
		webSide1.loadData(html1, "text/html", "utf-8");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void viewImagen(View view){
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/*");
		startActivityForResult(intent, 1);
	}

	@Override
	public void onActivityResult(int request, int result, Intent intent){
		try{
			Uri uri = intent.getData();
			String mime = getContentResolver().getType(uri);
			Log.d("clase18", "URI: "+uri.toString());
			String html2="<img src="+uri.toString()+">";
			webSide2.setInitialScale(25);
			webSide2.loadData(html2, "text/html", "utf-8");
			html1 = "Se ha cargado la imagen <br />"+
			"URI: "+uri.toString()+"<br />"+
			"MimeType: "+mime+"<br />";
		}catch(Exception e){
			html1 = "<b>No se ha cargado la Imagen</b>";
		}
		webSide1.loadData(html1, "text/html", "utf-8");
	}

}
