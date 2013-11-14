package com.udb.modulo1.clase17;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ClienteWeb extends WebViewClient {
	TextView textView;
	
	public ClienteWeb(TextView textView){
		this.textView = textView;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		textView.setText(url);
	}
	
	
}
