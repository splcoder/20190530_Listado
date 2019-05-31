package com.example.a2019_05_30_listado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import es.dmoral.toasty.Toasty;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	ListView listView;
	ArrayList<String> arrayListBots;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		// Back button on action bar
		getSupportActionBar().setDisplayHomeAsUpEnabled( true );

		listView = findViewById( R.id.list );

		arrayListBots = new ArrayList<>();
		arrayListBots.add( "Johnny 5" );
		arrayListBots.add( "Terminator" );
		arrayListBots.add( "R2 D2" );
		arrayListBots.add( "Mazinger Z" );
		arrayListBots.add( "Afrodita" );
		arrayListBots.add( "Conan" );
		arrayListBots.add( "Transformers" );
		arrayListBots.add( "Peter Griffing" );
		arrayListBots.add( "Bender" );
		arrayListBots.add( "Sun" );

		Collections.sort( arrayListBots );

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayListBots );
		listView.setAdapter( adaptador );

		listView.setOnItemClickListener( this );
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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String sSelected = arrayListBots.get( position );
		Toasty.info( getApplicationContext(), "Has seleccionado: " + sSelected, Toast.LENGTH_SHORT, true ).show();
	}
}
