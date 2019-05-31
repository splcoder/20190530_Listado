package com.example.a2019_05_30_listado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CalculatorActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		// Back button on action bar
		getSupportActionBar().setDisplayHomeAsUpEnabled( true );
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item ) {
		switch( item.getItemId() ){
			// Back button on action bar
			case android.R.id.home: {
				this.finish();
				return true;
			}
			default:;
		}
		return super.onOptionsItemSelected( item );
	}
}
