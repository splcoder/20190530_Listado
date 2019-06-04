package com.example.a2019_05_30_listado;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2019_05_30_listado.helpers.Cache;

import es.dmoral.toasty.Toasty;

// TODO more color buttons
public class MainActivity extends AppCompatActivity {
	private static String MY_PREFERENCES	= "my_prefs";
	private static String PREF_EMAIL		= "pref_email";
	private static String PREF_PASS			= "pref_pass";
	private static String PREF_REMIND_ME	= "pref_remind_me";

	EditText txtEmail;
	EditText txtPass;
	CheckBox cbRemindMe;
	Button btnEnter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtEmail = findViewById( R.id.txtEmail );
		txtPass = findViewById( R.id.txtPass );
		cbRemindMe = findViewById( R.id.cbRemindMe );
		btnEnter = findViewById( R.id.btnEnter );

		// Set data if saved
		SharedPreferences pref = getSharedPreferences( MY_PREFERENCES, Context.MODE_PRIVATE );
		txtEmail.setText( pref.getString( PREF_EMAIL, "" ) );
		txtPass.setText( pref.getString( PREF_PASS, "" ) );
		cbRemindMe.setChecked( pref.getBoolean( PREF_REMIND_ME, false ) );

		btnEnter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String sCheckEmail = "www3.spl@gmail.com";
				String sCheckPass = "entraya";
				String sTxtEmail = txtEmail.getText().toString();
				String sTxtPass = txtPass.getText().toString();

				if( sTxtEmail == null || sTxtEmail.isEmpty() ){
					Toasty.error( getApplicationContext(),"Debes introducir el email.", Toast.LENGTH_SHORT,true ).show();
					return;
				}
				if( sTxtPass == null || sTxtPass.isEmpty() ){
					Toasty.error( getApplicationContext(),"Debes introducir el password.", Toast.LENGTH_SHORT,true ).show();
					return;
				}
				if( ! sTxtEmail.equals( sCheckEmail ) || ! sTxtPass.equals( sCheckPass ) ){
					Toasty.error( getApplicationContext(),"Email o password incorrecto.", Toast.LENGTH_SHORT,true ).show();
				}
				else {
					Cache.set( "email", sCheckEmail );

					// Save preferences
					if( cbRemindMe.isChecked() ){   // See onStart
						// Save the data in the phone
						SharedPreferences.Editor editor = getSharedPreferences( MY_PREFERENCES, MODE_PRIVATE ).edit();
						editor.putString( PREF_EMAIL, sTxtEmail );
						editor.putString( PREF_PASS, sTxtPass );
						editor.putBoolean( PREF_REMIND_ME, true );
						//editor.apply();
						editor.commit();
					}
					else{
						// Clean phone data
						SharedPreferences.Editor editor = getSharedPreferences( MY_PREFERENCES, MODE_PRIVATE ).edit();
						editor.clear();
						editor.commit();
					}

					// Go to the menu
					Intent intent = new Intent(MainActivity.this, MenuActivity.class );
					startActivity( intent );
				}
			}
		});
	}
}
