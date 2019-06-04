package com.example.a2019_05_30_listado.activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a2019_05_30_listado.ListNotesActivity;
import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.Note;
import com.example.a2019_05_30_listado.data.Priority;
import com.example.a2019_05_30_listado.helpers.Cache;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class ModifyNoteActivity extends AppCompatActivity {

	Note note;

	EditText txtDate;
	Spinner spinnerNoteType;
	EditText txtText;
	Button btnModify;
	Button btnCancel;

	String myDateFormat = "yyyy-MM-dd";
	SimpleDateFormat sdf = new SimpleDateFormat( myDateFormat, Locale.getDefault() );
	Calendar calendar = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modify_note);

		note = (Note)Cache.get( "modifyNote" );

		txtDate = findViewById( R.id.txtDate );
		spinnerNoteType = findViewById( R.id.spinnerNoteType );
		txtText = findViewById( R.id.txtText );
		btnModify = findViewById( R.id.btnModify );
		btnCancel = findViewById( R.id.btnCancel );

		txtText.setText( note.getText() );

		//txtDate.setText( sdf.format( calendar.getTime() ) );
		txtDate.setText( sdf.format( note.getCreationDate() ) );
		txtDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				readDate( Calendar.getInstance() );
			}
		});

		// Fill the spinner
		ArrayAdapter<Priority> spinnerAdapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, Priority.values() );
		spinnerNoteType.setAdapter( spinnerAdapter );
		spinnerNoteType.setSelection( Priority.getIndex( note.getPriority() ) );

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toasty.info( getApplicationContext(), "Canceled", Toast.LENGTH_SHORT, true ).show();
				finish();
			}
		});
		btnModify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				note.setText( txtText.getText().toString() );
				note.setPriority( (Priority)spinnerNoteType.getSelectedItem() );
				// ... modify the date with "calendar"...
				Toasty.info( getApplicationContext(), "Modified", Toast.LENGTH_SHORT, true ).show();
				// Close this window
				finish();
			}
		});
	}

	private void readDate( Calendar date ){
		int year = date.get( Calendar.YEAR );
		int month = date.get( Calendar.MONTH );
		int day = date.get( Calendar.DAY_OF_MONTH );

		DatePickerDialog datePickerDialog = new DatePickerDialog( ModifyNoteActivity.this, datePickerListener, year, month, day );
		datePickerDialog.setTitle( "Select a date" );
		datePickerDialog.show();
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int month, int dayOfMonth ) {
			//calendar.set( year, month, dayOfMonth );
			calendar.set( Calendar.YEAR, year );
			calendar.set( Calendar.MONTH, month );
			calendar.set( Calendar.DAY_OF_MONTH, dayOfMonth );
			txtDate.setText( sdf.format( calendar.getTime() ) );
		}
	};
}
