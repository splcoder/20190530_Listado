package com.example.a2019_05_30_listado.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.a2019_05_30_listado.R;

/**
 * El ConstraintLayout 'base' debe tener _todo_ wrap_content
 * 		y el xml:	android:background="@drawable/border"
 *
 * Y el manifest:	android:theme="@style/AppTheme.NoActionBar.Dialog"
 *
 * En styles.xml:
 * 	<style name="AppTheme.NoActionBar.Dialog" parent="Theme.AppCompat.Light.Dialog">
 * 		<item name="windowActionBar">false</item>
 * 		<item name="windowNoTitle">true</item>
 * 	</style>
 */
public class InformationActivity extends AppCompatActivity {
	TextView txtType;
	TextView txtInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);

		txtType = findViewById( R.id.txtType );
		txtInfo = findViewById( R.id.txtInfo );

		Bundle extras = getIntent().getExtras();
		int iType = extras.getInt( "type", 0 );
		txtType.setText( iType );
		int iTxt = extras.getInt( "txt", 0 );
		txtInfo.setText( iTxt );
	}
}
