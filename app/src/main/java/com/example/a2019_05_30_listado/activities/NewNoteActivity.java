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
import java.util.List;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class NewNoteActivity extends AppCompatActivity {

	EditText txtDate;
	Spinner spinnerNoteType;
	EditText txtText;
	Button btnCreate;
	Button btnCancel;

	String myDateFormat = "yyyy-MM-dd";
	SimpleDateFormat sdf = new SimpleDateFormat( myDateFormat, Locale.getDefault() );
	Calendar calendar = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_note);

		txtDate = findViewById( R.id.txtDate );
		spinnerNoteType = findViewById( R.id.spinnerNoteType );
		txtText = findViewById( R.id.txtText );
		btnCreate = findViewById( R.id.btnCreate );
		btnCancel = findViewById( R.id.btnCancel );

		txtDate.setText( sdf.format( calendar.getTime() ) );
		txtDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				readDate( Calendar.getInstance() );
			}
		});

		// Fill the spinner
		ArrayAdapter<Priority> spinnerAdapter = new ArrayAdapter<>( this, android.R.layout.simple_spinner_item, Priority.values() );
		spinnerNoteType.setAdapter( spinnerAdapter );

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toasty.info( getApplicationContext(), "Canceled", Toast.LENGTH_SHORT, true ).show();
				finish();
			}
		});
		btnCreate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Note note = new Note( txtText.getText().toString(), (Priority)spinnerNoteType.getSelectedItem() );
				// ... modify the date with "calendar"...
				((ListNotesActivity)Cache.get( "listNotesActivity" )).addNote( note );
				Toasty.info( getApplicationContext(), "Added", Toast.LENGTH_SHORT, true ).show();
				// Close this window
				finish();
			}
		});
	}

	private void readDate( Calendar date ){
		int year = date.get( Calendar.YEAR );
		int month = date.get( Calendar.MONTH );
		int day = date.get( Calendar.DAY_OF_MONTH );

		DatePickerDialog datePickerDialog = new DatePickerDialog( NewNoteActivity.this, datePickerListener, year, month, day );
		datePickerDialog.setTitle( "Select a date" );
		datePickerDialog.show();
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet( DatePicker view, int year, int month, int dayOfMonth ) {
			//calendar.set( year, month, dayOfMonth );
			calendar.set( Calendar.YEAR, year );
			calendar.set( Calendar.MONTH, month );
			calendar.set( Calendar.DAY_OF_MONTH, dayOfMonth );
			txtDate.setText( sdf.format( calendar.getTime() ) );
		}
	};
}
