package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

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
	Button btnAbs, btnMod, btnInv;
	Button btnRad, btnDeg, btnFactorial;
	Button btnFloor, btnRound, btnCeil;
	Button btnPow2, btnPow3, btnXpowX;
	Button btnRoot2, btnRoot3, btnRoot;
	Button btnExp, btnExp10, btnPow;
	Button btnLn, btnLog10, btnLog;
	Button btnSin, btnCos, btnTan;
	Button btnArcSin, btnArcCos, btnArcTan;
	Button btnSinh, btnCosh, btnTanh;
	Button btnArcSinh, btnArcCosh, btnArcTanh;
	Button btnLambertW_1, btnLambertW, btnInvXpowX;

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

		btnAbs = findViewById( R.id.btnAbs );		btnMod = findViewById( R.id.btnMod );		btnInv = findViewById( R.id.btnInverse );
		btnRad = findViewById( R.id.btnRad );		btnDeg = findViewById( R.id.btnDeg );		btnFactorial = findViewById( R.id.btnFactorial );
		btnFloor = findViewById( R.id.btnFloor );	btnRound = findViewById( R.id.btnRound );	btnCeil = findViewById( R.id.btnCeil );
		btnPow2 = findViewById( R.id.btnPow2 );		btnPow3 = findViewById( R.id.btnPow3 );		btnXpowX = findViewById( R.id.btnXpowX );
		/*Button btnRoot2, btnRoot3, btnRoot;
		Button btnExp, btnExp10, btnPow;
		Button btnLn, btnLog10, btnLog;
		Button btnSin, btnCos, btnTan;
		Button btnArcSin, btnArcCos, btnArcTan;
		Button btnSinh, btnCosh, btnTanh;
		Button btnArcSinh, btnArcCosh, btnArcTanh;
		Button btnLambertW_1, btnLambertW, btnInvXpowX;*/
	}
}
