package com.example.a2019_05_30_listado;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.activities.InformationActivity;
import com.example.a2019_05_30_listado.activities.ModifyNoteActivity;
import com.example.a2019_05_30_listado.activities.NewNoteActivity;
import com.example.a2019_05_30_listado.adapters.NotesAdapter;
import com.example.a2019_05_30_listado.data.Note;
import com.example.a2019_05_30_listado.data.NotesManager;
import com.example.a2019_05_30_listado.data.Priority;
import com.example.a2019_05_30_listado.helpers.Cache;
import com.example.a2019_05_30_listado.helpers.Console;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class ListNotesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	ListView listView;
	NotesAdapter notesAdapter = null;
	ArrayList<Note> arrayListNotes;
	FloatingActionButton btnFloatingAdd;

	ListNotesActivity that = this;

	NotesManager notesManager;

	private void fillArray(){
		try {
			notesManager = new NotesManager( getApplicationContext() );
			arrayListNotes = notesManager.getAllNotes();
			if( notesAdapter != null ){
				notesAdapter.clear();
				notesAdapter.addAll( arrayListNotes );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_notes);

		// Back button on action bar
		getSupportActionBar().setDisplayHomeAsUpEnabled( true );

		listView = findViewById( R.id.listNotes );

		/*arrayListNotes = new ArrayList<>();
		arrayListNotes.add( new Note( "Dar un paseo", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Ir de tapas", Priority.IMPORTANT ) );
		arrayListNotes.add( new Note( "Partida de mus", Priority.URGENT ) );
		arrayListNotes.add( new Note( "Tomar el sol", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Dar un baño", Priority.NORMAL ) );
		arrayListNotes.add( new Note( "Comer un helado", Priority.URGENT ) );
		arrayListNotes.add( new Note( "Comer patatas fritas", Priority.IMPORTANT ) );
		arrayListNotes.add( new Note( "Comprar cafeina", Priority.URGENT ) );*/
		fillArray();

		//Collections.sort( arrayListnNotes );

		//ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayListBots );
		notesAdapter = new NotesAdapter( this, arrayListNotes );
		listView.setAdapter( notesAdapter );
		listView.setOnItemClickListener( this );	// <<< See below: onItemClick

		// Floating button "add"
		btnFloatingAdd = findViewById( R.id.btnFloatingAdd );
		btnFloatingAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent( ListNotesActivity.this, NewNoteActivity.class );
				Intent intent = new Intent( getApplicationContext(), NewNoteActivity.class );
				//Cache.set( "listNotesActivity", this );	// <<< Gives ERROR !!!
				Cache.set( "listNotesActivity", that );
				startActivity( intent );
			}
		});

		// Delete an item
		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				//arrayListNotes.remove( position );
				//notesAdapter.notifyDataSetChanged();
				confirmDeleteNote( position );
				//return false;	// <<< se ejecuta OnItemLongClick y onItemClick
				return true;	// <<< sólo se ejecuta OnItemLongClick
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
			// --- Menu --- >>> see onCreateOptionsMenu()
			case R.id.idItemAbout: {
				// Show window about
				//Toasty.info( getApplicationContext(),"Has pulsado About", Toast.LENGTH_SHORT,true ).show();
				Intent intent = new Intent( ListNotesActivity.this, InformationActivity.class );
				intent.putExtra( "type", R.string.strTypeAbout );
				intent.putExtra( "txt", R.string.strAbout );
				startActivity( intent );
				return true;
			}
			case R.id.idItemPrivacy: {
				// Show window with the politics' privacy
				//Toasty.info( getApplicationContext(),"Has pulsado Privacy", Toast.LENGTH_SHORT,true ).show();
				Intent intent = new Intent( ListNotesActivity.this, InformationActivity.class );
				intent.putExtra( "type", R.string.strTypePrivacy );
				intent.putExtra( "txt", R.string.strPrivacy );
				startActivity( intent );
				return true;
			}
			case R.id.idItemSyncUp: {
				// Show window with the politics' privacy
				Toasty.info( getApplicationContext(),"Has pulsado Sync up", Toast.LENGTH_SHORT,true ).show();
				/*Intent intent = new Intent( ListNotesActivity.this, InformationActivity.class );
				startActivity( intent );*/
				return true;
			}
			default:;
		}
		return super.onOptionsItemSelected( item );
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Note note = arrayListNotes.get( position );
		Cache.set( "modifyNote", note );
		Intent intent = new Intent( ListNotesActivity.this, ModifyNoteActivity.class );
		startActivity( intent );
	}

	/**
	 * For using in NewNoteActivity
	 * @param note
	 */
	public void addNote( Note note ){
		arrayListNotes.add( note );
		notesAdapter.notifyDataSetChanged();

		notesManager.add( note );
	}

	@Override
	protected void onStart() {
		super.onStart();
		notesAdapter.notifyDataSetChanged();
	}

	public void confirmDeleteNote( final int position ){
		//AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( getApplicationContext() );	// <<< gives error
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( ListNotesActivity.this );
		alertDialogBuilder.setTitle( "Alert !" );
		//alertDialogBuilder.setIcon( R.drawable.ic_delete );
		alertDialogBuilder
				.setMessage( "Are you sure ?" )
				.setCancelable( false )
				.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
					public void onClick( DialogInterface dialog, int id ) {
						arrayListNotes.remove( position );
						notesAdapter.notifyDataSetChanged();
						//dialog.cancel();
					}
				})
				.setNegativeButton( "No", new DialogInterface.OnClickListener() {
					public void onClick( DialogInterface dialog, int id ) {
						// cancel
						//dialog.cancel();
					}
				});
		// Create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
		// Show it
		alertDialog.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		try {
			// The data is saved in the "View -> Tool Windows -> Device File Explorer >>> data/data/your_app/files/"
			notesManager.writeAll();
			//Log.e( "onPause", "notesManager.writeAll();" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*@Override
	protected void onResume() {
		super.onResume();
		fillArray();
	}*/

	/**
	 * Draw the menu
	 * @param menu
	 * @return boolean
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//return super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate( R.menu.list_notes_menu, menu );
		return true;
	}
}
