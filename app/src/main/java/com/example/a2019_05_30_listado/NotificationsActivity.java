package com.example.a2019_05_30_listado;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

	Button btnToast;
	Button btnToasty;
	Button btnSnackbar;
	Button btnGoBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);

		btnToast = findViewById( R.id.btnToast );
		btnToasty = findViewById( R.id.btnToasty );
		btnSnackbar = findViewById( R.id.btnSnackbar );
		btnGoBack = findViewById( R.id.btnGoBack );

		btnToast.setOnClickListener( this );
		btnToasty.setOnClickListener( this );
		btnSnackbar.setOnClickListener( this );
		btnGoBack.setOnClickListener( this );
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnToast: {
				Toast.makeText( getApplicationContext(), "Hi, this is Toast", Toast.LENGTH_SHORT ).show();
				break;
			}
			case R.id.btnToasty: {
				Toasty.info( getApplicationContext(),"Hi, this is Toasty", Toast.LENGTH_SHORT,true ).show();
				break;
			}
			case R.id.btnSnackbar: {
				Snackbar.make( v,"Hi, this is Snackbar", Snackbar.LENGTH_SHORT ).show();
				break;
			}
			case R.id.btnGoBack: {
				Intent intent = new Intent( NotificationsActivity.this, MenuActivity.class );
				startActivity( intent );
				break;
			}
		}
	}
}
