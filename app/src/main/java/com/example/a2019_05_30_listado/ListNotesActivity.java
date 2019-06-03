package com.example.a2019_05_30_listado;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.activities.NewNoteActivity;
import com.example.a2019_05_30_listado.adapters.NotesAdapter;
import com.example.a2019_05_30_listado.data.Note;
import com.example.a2019_05_30_listado.data.Priority;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class ListNotesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	ListView listView;
	ArrayList<Note> arrayListNotes;
	FloatingActionButton btnFloatingAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_notes);

		// Back button on action bar
		getSupportActionBar().setDisplayHomeAsUpEnabled( true );

		listView = findViewById( R.id.listNotes );

		arrayListNotes = new ArrayList<>();
		arrayListNotes.add( new Note( "Dar un paseo", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Ir de tapas", Priority.IMPORTANT ) );
		arrayListNotes.add( new Note( "Partida de mus", Priority.URGENT ) );
		arrayListNotes.add( new Note( "Tomar el sol", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Dar un baño", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Comer un helado", Priority.URGENT ) );
		arrayListNotes.add( new Note( "Comer patatas fritas", Priority.IMPORTANT ) );
		arrayListNotes.add( new Note( "Comprar cafeina", Priority.URGENT ) );

		//Collections.sort( arrayListnNotes );

		//ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayListBots );
		NotesAdapter notesAdapter = new NotesAdapter( this, arrayListNotes );
		listView.setAdapter( notesAdapter );
		listView.setOnItemClickListener( this );	// <<< See below: onItemClick

		// Floating button "add"
		btnFloatingAdd = findViewById( R.id.btnFloatingAdd );
		btnFloatingAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent( ListNotesActivity.this, NewNoteActivity.class );
				startActivity( intent );
			}
		});
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
		Note note = arrayListNotes.get( position );
		Toasty.info( getApplicationContext(), "Has seleccionado: " + note.getText(), Toast.LENGTH_SHORT, true ).show();
	}
}
