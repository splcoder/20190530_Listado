package com.example.a2019_05_30_listado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.MemVar;

import java.util.ArrayList;

public class ConstantsAdapter extends ArrayAdapter<MemVar> {
	private ArrayList<MemVar> listMemVar;
	private Context context;
	private int lastPosition = -1;

	public ConstantsAdapter( Context context, ArrayList<MemVar> listMemVar ){
		super( context, R.layout.activity_popup_mem, listMemVar );
		this.listMemVar = listMemVar;
		this.context = context;
	}

	// For R.layout.activity_popup_mem_save
	public ConstantsAdapter( Context context, int layoutResource, ArrayList<MemVar> listMemVar ){
		super( context, layoutResource, listMemVar );
		this.listMemVar = listMemVar;
		this.context = context;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent ){
		// Get the data item for this position
		MemVar memVar = getItem( position );
		// Check if an existing view is being reused, otherwise inflate the view
		if( convertView == null ){
			convertView = LayoutInflater.from( getContext() ).inflate( R.layout.item_constant, parent,false );
		}
		// Lookup view for data population
		TextView txtName = (TextView)convertView.findViewById( R.id.txtName );
		TextView txtValue = (TextView)convertView.findViewById( R.id.txtValue );
		// Populate the data into the template view using the data object
		txtName.setText( memVar.getName() );
		txtValue.setText( String.valueOf( memVar.getValue() ) );
		// Return the completed view to render on screen
		return convertView;
	}
}