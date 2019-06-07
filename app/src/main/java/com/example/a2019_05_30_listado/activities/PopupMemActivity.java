package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.MemVar;
import com.example.a2019_05_30_listado.helpers.Cache;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class PopupMemActivity extends AppCompatActivity implements View.OnClickListener {

	Button btnMem;
	Button btnConstants;
	Button btnUserConstants;
	ListView listValues;

	CalculatorActivity calculatorActivity;
	ArrayList<MemVar> aMemory;
	ArrayAdapter<MemVar> aMemAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_mem);

		btnMem = findViewById( R.id.btnMem );
		btnConstants = findViewById( R.id.btnConstants );
		btnUserConstants = findViewById( R.id.btnUserConstants );
		listValues = findViewById( R.id.listValues );

		btnMem.setOnClickListener( this );
		btnConstants.setOnClickListener( this );
		btnUserConstants.setOnClickListener( this );

		calculatorActivity = (CalculatorActivity) Cache.get( "calculatorActivity" );
		aMemory = calculatorActivity.getMemory();
		aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
		listValues.setAdapter( aMemAdapter );

		listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// The selected button is the NOT enabled
				if( ! btnMem.isEnabled() )				calculatorActivity.setValue( aMemory.get( position ).getValue() );
				finish();
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnMem: {
				btnMem.setTextColor( getResources().getColor( R.color.red ) );
				btnMem.setEnabled( false );
				btnConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnConstants.setEnabled( true );
				btnUserConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnUserConstants.setEnabled( true );

				listValues.setAdapter( aMemAdapter );
				break;
			}
			case R.id.btnConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnConstants.setEnabled( false );
				btnUserConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnUserConstants.setEnabled( true );
				// TODO
				break;
			}
			case R.id.btnUserConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnConstants.setEnabled( true );
				btnUserConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnUserConstants.setEnabled( false );

				// TODO
				break;
			}
		}
	}
}
