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
import com.example.a2019_05_30_listado.adapters.ConstantsAdapter;
import com.example.a2019_05_30_listado.data.MemVar;
import com.example.a2019_05_30_listado.helpers.Cache;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class PopupMemActivity extends AppCompatActivity implements View.OnClickListener {
	final int MEM_ADAPTER				= 0;
	final int CONSTANTS_ADAPTER			= 1;
	final int USER_CONSTANTS_ADAPTER	= 2;

	Button btnMem;
	Button btnConstants;
	Button btnUserConstants;
	ListView listValues;

	CalculatorActivity calculatorActivity;
	ArrayList<MemVar> aMemory;
	ArrayAdapter<MemVar> aMemAdapter;

	ArrayList<MemVar> aConstants;
	ArrayList<MemVar> aUserConstants;
	ConstantsAdapter constantsAdapter;	// <<< For aConstants and aUserConstants <<< for showing the "name and value" of the constants

	// TODO improve ConstantsAdapter colors...
	private void setAdapterType( int type ){
		switch( type ){
			case MEM_ADAPTER: {
				/*aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
				listValues.setAdapter( aMemAdapter );*/
				constantsAdapter = new ConstantsAdapter( this, R.layout.activity_popup_mem, aMemory, ConstantsAdapter.MEM_ARRAY );
				listValues.setAdapter( constantsAdapter );
				listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// The selected button is the NOT enabled
						if( ! btnMem.isEnabled() )				calculatorActivity.setValue( aMemory.get( position ).getValue() );
						finish();
					}
				});
				break;
			}
			case CONSTANTS_ADAPTER: {
				constantsAdapter = new ConstantsAdapter( this, R.layout.activity_popup_mem, aConstants, ConstantsAdapter.CONSTANTS_ARRAY );
				listValues.setAdapter( constantsAdapter );
				listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// The selected button is the NOT enabled
						if( ! btnConstants.isEnabled() )		calculatorActivity.setValue( aConstants.get( position ).getValue() );
						finish();
					}
				});
				break;
			}
			case USER_CONSTANTS_ADAPTER: {
				constantsAdapter = new ConstantsAdapter( this, R.layout.activity_popup_mem, aUserConstants, ConstantsAdapter.USER_CONSTANTS_ARRAY );
				listValues.setAdapter( constantsAdapter );
				listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// The selected button is the NOT enabled
						if( ! btnUserConstants.isEnabled() )	calculatorActivity.setValue( aUserConstants.get( position ).getValue() );
						finish();
					}
				});
				break;
			}
		}
	}

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
		/*aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
		listValues.setAdapter( aMemAdapter );
		listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// The selected button is the NOT enabled
				if( ! btnMem.isEnabled() )				calculatorActivity.setValue( aMemory.get( position ).getValue() );
				finish();
			}
		});*/
		setAdapterType( MEM_ADAPTER );

		aConstants = calculatorActivity.getConstants();
		aUserConstants = calculatorActivity.getUserConstants();
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

				//listValues.setAdapter( aMemAdapter );
				setAdapterType( MEM_ADAPTER );
				break;
			}
			case R.id.btnConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnConstants.setEnabled( false );
				btnUserConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnUserConstants.setEnabled( true );

				setAdapterType( CONSTANTS_ADAPTER );
				break;
			}
			case R.id.btnUserConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnConstants.setEnabled( true );
				btnUserConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnUserConstants.setEnabled( false );

				setAdapterType( USER_CONSTANTS_ADAPTER );
				break;
			}
		}
	}
}
