package com.seanisko.smsreader;

import android.app.*;
import android.os.*;
import android.webkit.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		WebView main = new WebView(this);
		main.loadUrl("file:///android_asset/gpl-3.0-standalone.html");
		setContentView(main);
    }
}
