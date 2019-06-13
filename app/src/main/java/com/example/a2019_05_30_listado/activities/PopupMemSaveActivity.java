package com.example.a2019_05_30_listado.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.a2019_05_30_listado.helpers.DialogConfirm;

import java.util.ArrayList;

import static com.example.a2019_05_30_listado.activities.PopupMemActivity.CONSTANTS_ADAPTER;
import static com.example.a2019_05_30_listado.activities.PopupMemActivity.MEM_ADAPTER;
import static com.example.a2019_05_30_listado.activities.PopupMemActivity.USER_CONSTANTS_ADAPTER;

public class PopupMemSaveActivity extends AppCompatActivity implements View.OnClickListener {
	PopupMemSaveActivity that = this;

	Button btnMem;
	Button btnAdd;
	Button btnUserConstants;
	ListView listValues;

	CalculatorActivity calculatorActivity;
	ArrayList<MemVar> aMemory;
	ArrayAdapter<MemVar> aMemAdapter;

	ArrayList<MemVar> aUserConstants;
	ArrayAdapter<MemVar> aUserConstantsAdapter;	// <<< TODO use better another adapter for showing the name of the cte.

	ConstantsAdapter constantsAdapter;	// <<< for showing the "name and value" of the constants

	private void setAdapterType( int type ){
		switch( type ){
			case MEM_ADAPTER: {
				/*aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
				listValues.setAdapter( aMemAdapter );*/
				constantsAdapter = new ConstantsAdapter( this, R.layout.activity_popup_mem_save, aMemory, ConstantsAdapter.MEM_ARRAY );
				listValues.setAdapter( constantsAdapter );
				listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// The selected button is the NOT enabled
						if( ! btnMem.isEnabled() )				calculatorActivity.setValue( aMemory.get( position ).getValue() );
						finish();
					}
				});
				listValues.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
					@Override
					public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
						aMemory.remove( position );
						constantsAdapter.notifyDataSetChanged();
						//return false;	// <<< The click event is executed
						return true;	// <<< Only the longClick is executed
					}
				});
				break;
			}
			case USER_CONSTANTS_ADAPTER: {
				constantsAdapter = new ConstantsAdapter( this, R.layout.activity_popup_mem_save, aUserConstants, ConstantsAdapter.USER_CONSTANTS_ARRAY );
				listValues.setAdapter( constantsAdapter );
				listValues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						// The selected button is the NOT enabled
						if( ! btnUserConstants.isEnabled() )	calculatorActivity.setValue( aUserConstants.get( position ).getValue() );
						finish();
					}
				});
				listValues.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
					@Override
					public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
						//aUserConstants.remove( position );
						//constantsAdapter.notifyDataSetChanged();
						/*new AlertDialog.Builder( that )
								.setIcon( android.R.drawable.ic_dialog_alert )
								.setTitle( "Delete" )
								.setMessage( "Are you sure ?" )
								.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										aUserConstants.remove( position );
										constantsAdapter.notifyDataSetChanged();
									}

								})
								.setNegativeButton( "No", null)
								.show();*/
						DialogConfirm dialogConfirm = new DialogConfirm( that, "Delete", "Are you sure ?", "Yes", "No" );
						dialogConfirm.setOnButtonClicked( new DialogConfirm.OnButtonClicked(){
							@Override
							public void exe( boolean confirmed ) {
								if( confirmed ){
									aUserConstants.remove( position );
									constantsAdapter.notifyDataSetChanged();
								}
							}
 						});
 						dialogConfirm.show();

						//return false;	// <<< The click event is executed
						return true;	// <<< Only the longClick is executed
					}
				});
				break;
			}
		}
	}

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
		/*aMemAdapter = new ArrayAdapter<MemVar>( this, android.R.layout.simple_list_item_1, aMemory );
		listValues.setAdapter( aMemAdapter );
		listValues.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				aMemory.remove( position );
				aMemAdapter.notifyDataSetChanged();
				//return false;	// <<< The click event is executed
				return true;	// <<< Only the longClick is executed
			}
		});*/
		setAdapterType( MEM_ADAPTER );

		aUserConstants = calculatorActivity.getUserConstants();
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnMem: {
				btnMem.setTextColor( getResources().getColor( R.color.red ) );
				btnMem.setEnabled( false );
				btnUserConstants.setTextColor( getResources().getColor( R.color.white ) );
				btnUserConstants.setEnabled( true );

				//listValues.setAdapter( aMemAdapter );
				setAdapterType( MEM_ADAPTER );
				break;
			}
			case R.id.btnUserConstants: {
				btnMem.setTextColor( getResources().getColor( R.color.white ) );
				btnMem.setEnabled( true );
				btnUserConstants.setTextColor( getResources().getColor( R.color.red ) );
				btnUserConstants.setEnabled( false );

				setAdapterType( USER_CONSTANTS_ADAPTER );
				break;
			}
			case R.id.btnAdd: {
				if( ! btnMem.isEnabled() ){
					aMemory.add( new MemVar( Double.parseDouble( (String)Cache.get( "value" ) ), "" ) );
					//aMemAdapter.notifyDataSetChanged();
					constantsAdapter.notifyDataSetChanged();
					finish();
				}
				else{
					// TODO window to set a name too
					aUserConstants.add( new MemVar( Double.parseDouble( (String)Cache.get( "value" ) ), "" ) );
					//aMemAdapter.notifyDataSetChanged();
					constantsAdapter.notifyDataSetChanged();
					finish();
				}
				break;
			}
		}
	}
}
