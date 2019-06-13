package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.MemVar;
import com.example.a2019_05_30_listado.helpers.Cache;

public class SetUserConstNameActivity extends AppCompatActivity {

	EditText txtName;
	TextView txtValue;
	Button btnCreate;
	Button btnCancel;

	PopupMemSaveActivity popupMemSaveActivity;
	String value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_user_const_name);

		txtName = findViewById( R.id.txtName );
		txtValue = findViewById( R.id.txtValue );
		btnCreate = findViewById( R.id.btnCreate );
		btnCancel = findViewById( R.id.btnCancel );

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		btnCreate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				popupMemSaveActivity.getUserConstants().add( new MemVar( Double.parseDouble( value ), txtName.getText().toString() ) );
				popupMemSaveActivity.getAdapter().notifyDataSetChanged();
				//popupMemSaveActivity.finish();

				finish();
			}
		});

		popupMemSaveActivity = (PopupMemSaveActivity)Cache.get( "PopupMemSaveActivity" );
		value = (String)Cache.get( "value" );
		txtValue.setText( value );
	}
}
