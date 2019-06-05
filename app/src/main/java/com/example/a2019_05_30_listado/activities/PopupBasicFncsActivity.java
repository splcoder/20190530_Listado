package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.a2019_05_30_listado.R;

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
public class PopupBasicFncsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_basic_fncs);

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
	}
}
