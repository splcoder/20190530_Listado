package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.MemVar;
import com.example.a2019_05_30_listado.helpers.Cache;

import java.util.ArrayList;

public class PopupMemSaveActivity extends AppCompatActivity implements View.OnClickListener {

	Button btnMem;
	Button btnAdd;
	Button btnUserConstants;
	ListView listValues;

	CalculatorActivity calculatorActivity;
	ArrayList<MemVar> aMemory;
	ArrayAdapter<MemVar> aMemAdapter;

	ArrayList<MemVar> aUserConstants;
	ArrayAdapter<MemVar> aUserConstantsAdapter;	// <<< TODO use better another adapter for showing the name of the cte.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_mem_save);

		btnMem = findViewById( R.id.btnMem );
		btnAdd = findViewById( R.id.btnAdd );
		btnUserConstants = findViewById( R.id.btnUserConstants );
		listValues = findViewById( R.id.listValues );

		btnMem.setOnClickListener( this );
		btnAdd.setOnClickListener( this );
		btnUserConstants.setOnClickListener( this );

		calculatorActivity = (CalculatorActivity)Cache.get( "calculatorActivity" );
		aMemory = calculatorActivity.getMemory();
		aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
		listValues.setAdapter( aMemAdapter );
		listValues.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				aMemory.remove( position );
				aMemAdapter.notifyDataSetChanged();
				//return false;	// <<< The click event is executed
				return true;	// <<< Only the longClick is executed
			}
		});

		aUserConstants = calculatorActivity.getUserConstants();
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnMem: {
				btnUserConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnUserConstants.setEnabled( true );
				btnMem.setTextColor( getResources().getColor( R.color.red ) );
				btnMem.setEnabled( false );

				listValues.setAdapter( aMemAdapter );
				break;
			}
			case R.id.btnUserConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnUserConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnUserConstants.setEnabled( false );

				// TODO
				break;
			}
			case R.id.btnAdd: {
				if( ! btnMem.isEnabled() ){
					aMemory.add( new MemVar( Double.parseDouble( (String)Cache.get( "value" ) ), "" ) );
					aMemAdapter.notifyDataSetChanged();
					finish();
				}
				else{
					// TODO
				}
				break;
			}
		}
	}
}
