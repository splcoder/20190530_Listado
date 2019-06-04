package com.example.a2019_05_30_listado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.activities.CalculatorActivity;
import com.example.a2019_05_30_listado.activities.SplashActivity;
import com.example.a2019_05_30_listado.helpers.Cache;

import es.dmoral.toasty.Toasty;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

	TextView txtGreeting;
	Button btnNotifications;
	Button btnList;
	Button btnListNotes;
	Button btnCalculator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		txtGreeting			= findViewById( R.id.txtGreeting );
		btnNotifications	= findViewById( R.id.btnNotifications );
		btnList				= findViewById( R.id.btnList );
		btnListNotes		= findViewById( R.id.btnListNotes );
		btnCalculator		= findViewById( R.id.btnCalculator );

		txtGreeting.setText( "Hola: " + Cache.get( "email" ) );
		btnNotifications.setOnClickListener( this );
		btnList.setOnClickListener( this );
		btnListNotes.setOnClickListener( this );
		btnCalculator.setOnClickListener( this );

		Toasty.info( getApplicationContext(),"Select an option", Toast.LENGTH_SHORT,true ).show();
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch( v.getId() ){
			case R.id.btnNotifications: {
				intent = new Intent( MenuActivity.this, NotificationsActivity.class );
				break;
			}
			case R.id.btnList: {
				intent = new Intent( MenuActivity.this, ListActivity.class );
				break;
			}
			case R.id.btnListNotes: {
				//intent = new Intent( MenuActivity.this, ListNotesActivity.class );
				intent = new Intent( MenuActivity.this, SplashActivity.class );
				break;
			}
			case R.id.btnCalculator: {
				intent = new Intent( MenuActivity.this, CalculatorActivity.class );
				break;
			}
			default:;
		}
		if( intent != null )	startActivity( intent );
	}
}
