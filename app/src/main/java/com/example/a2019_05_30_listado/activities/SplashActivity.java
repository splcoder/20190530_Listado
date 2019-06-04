package com.example.a2019_05_30_listado.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a2019_05_30_listado.ListNotesActivity;
import com.example.a2019_05_30_listado.R;

/**
 * App's presentation window
 */
public class SplashActivity extends AppCompatActivity {

	private final int SPLASH_DURATION = 3000; // 3 seconds

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable(){
			public void run(){
				// Go to ListNotesActivity
				Intent intent = new Intent( SplashActivity.this, ListNotesActivity.class );
				startActivity( intent );
				finish();
			};
		}, SPLASH_DURATION);
	}
}
