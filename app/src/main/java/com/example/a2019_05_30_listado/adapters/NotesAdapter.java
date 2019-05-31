package com.example.a2019_05_30_listado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.Note;
import com.example.a2019_05_30_listado.helpers.DateHelper;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<Note> {
	private ArrayList<Note> listNotes;
	private Context context;
	private int lastPosition = -1;

	public NotesAdapter( Context context, ArrayList<Note> listNotes ){
		super( context, R.layout.activity_list_notes, listNotes );
		this.listNotes = listNotes;
		this.context = context;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent ){
		// Get the data item for this position
		Note note = getItem( position );
		// Check if an existing view is being reused, otherwise inflate the view
		if( convertView == null ){
			convertView = LayoutInflater.from( getContext() ).inflate( R.layout.item_note, parent,false );
		}
		// Lookup view for data population
		ImageView imageView = (ImageView)convertView.findViewById( R.id.imgCategory );
		TextView txtDate = (TextView)convertView.findViewById( R.id.txtDate );
		TextView txtText = (TextView)convertView.findViewById( R.id.txtText );
		// Populate the data into the template view using the data object
		txtDate.setText( DateHelper.getDate( note.getCreationDate(),true ) );
		txtText.setText( note.getText() );
		switch( note.getPriority() ){
			case NORMAL:	imageView.setImageResource( R.drawable.ic_note_green );		break;
			case IMPORTANT:	imageView.setImageResource( R.drawable.ic_note_yellow );	break;
			case URGENT:	imageView.setImageResource( R.drawable.ic_note_red );		break;
		}
		// Return the completed view to render on screen
		return convertView;
	}

}
