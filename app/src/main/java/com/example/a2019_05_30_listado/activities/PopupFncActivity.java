package com.example.a2019_05_30_listado.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.CacheKeys;
import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.helpers.Cache;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

/**
 * Set in the manifest, in this activity:		android:theme="@style/AppTheme.PopupTheme"
 *
 * And in styles.xml:
 * 		<style name="AppTheme.PopupTheme">
 * 			<item name="android:windowIsTranslucent">true</item>
 * 			<item name="android:windowCloseOnTouchOutside">true</item>
 *
 * 			<item name="windowActionBar">false</item>
 * 			<item name="windowNoTitle">true</item>
 * 		</style>
 */
public class PopupFncActivity extends Activity implements AdapterView.OnItemClickListener {	// AppCompatActivity

	//Button btn;
	ListView listFncs;
	ArrayList<String> arrayFncs;
	Activity calculatorActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_fnc);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics( dm );

		int width	= (int)(dm.widthPixels * 0.8);
		int height	= (int)(dm.heightPixels * 0.7);

		getWindow().setLayout( width, height );

		/*WindowManager.LayoutParams params = getWindow().getAttributes();
		params.gravity = Gravity.CENTER;
		params.x = 0;
		params.y = -20;

		getWindow().setAttributes( params );*/

		//--------------------------

		listFncs = findViewById( R.id.listFncs );
		arrayFncs = new ArrayList<>();
		for( MathFunction mf : MathFunction.listFunctions ){
			arrayFncs.add( MathFunction.toString( mf ) );
		}
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayFncs );
		listFncs.setAdapter( adaptador );
		listFncs.setOnItemClickListener( this );	// <<< See below: onItemClick
	}

	@Override
	public void onItemClick( AdapterView<?> parent, View view, int position, long id ){
		((CalculatorActivity)Cache.get( CacheKeys.CALCULATOR_ACTIVITY )).exeFunction( MathFunction.listFunctions.get( position ) );
		Toasty.info( getApplicationContext(), "Fnc selected: " + arrayFncs.get( position ), Toast.LENGTH_SHORT, true ).show();
		// Close this window
		this.finish();
	}
}
