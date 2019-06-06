package com.example.a2019_05_30_listado.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.helpers.Cache;

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
public class PopupBasicFncsActivity extends AppCompatActivity implements View.OnClickListener {
	Button btnAbs, btnMod, btnInverse;
	Button btnRad, btnDeg, btnFactorial;
	Button btnFloor, btnRound, btnCeil;
	Button btnPow2, btnPow3, btnBy10Pow;
	Button btnRoot2, btnRoot3, btnRoot;
	Button btnExp, btnExp10, btnPow;
	Button btnLn, btnLog10, btnLog;
	Button btnSin, btnCos, btnTan;
	Button btnArcSin, btnArcCos, btnArcTan;
	Button btnSinh, btnCosh, btnTanh;
	Button btnArcSinh, btnArcCosh, btnArcTanh;
	Button btnHypot, btnAtan2, btnXpowX;
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

		btnAbs = findViewById( R.id.btnAbs );					btnMod = findViewById( R.id.btnMod );				btnInverse = findViewById( R.id.btnInverse );
		btnRad = findViewById( R.id.btnRad );					btnDeg = findViewById( R.id.btnDeg );				btnFactorial = findViewById( R.id.btnFactorial );
		btnFloor = findViewById( R.id.btnFloor );				btnRound = findViewById( R.id.btnRound );			btnCeil = findViewById( R.id.btnCeil );
		btnPow2 = findViewById( R.id.btnPow2 );					btnPow3 = findViewById( R.id.btnPow3 );				btnBy10Pow = findViewById( R.id.btnBy10Pow );
		btnRoot2 = findViewById( R.id.btnRoot2 );				btnRoot3 = findViewById( R.id.btnRoot3 );			btnRoot = findViewById( R.id.btnRoot );
		btnExp = findViewById( R.id.btnExp );					btnExp10 = findViewById( R.id.btnExp10 );			btnPow = findViewById( R.id.btnPow );
		btnLn = findViewById( R.id.btnLn );						btnLog10 = findViewById( R.id.btnLog10 );			btnLog = findViewById( R.id.btnLog );
		btnSin = findViewById( R.id.btnSin );					btnCos = findViewById( R.id.btnCos );				btnTan = findViewById( R.id.btnTan );
		btnArcSin = findViewById( R.id.btnArcSin );				btnArcCos = findViewById( R.id.btnArcCos );			btnArcTan = findViewById( R.id.btnArcTan );
		btnSinh = findViewById( R.id.btnSinh );					btnCosh = findViewById( R.id.btnCosh );				btnTanh = findViewById( R.id.btnTanh );
		btnArcSinh = findViewById( R.id.btnArcSinh );			btnArcCosh = findViewById( R.id.btnArcCosh );		btnArcTanh = findViewById( R.id.btnArcTanh );
		btnHypot = findViewById( R.id.btnHypot );				btnAtan2 = findViewById( R.id.btnAtan2 );			btnXpowX = findViewById( R.id.btnXpowX );
		btnLambertW_1 = findViewById( R.id.btnLambertW_1 );		btnLambertW = findViewById( R.id.btnLambertW );		btnInvXpowX = findViewById( R.id.btnInvXpowX );

		btnAbs.setOnClickListener( this );						btnMod.setOnClickListener( this );					btnInverse.setOnClickListener( this );
		btnRad.setOnClickListener( this );						btnDeg.setOnClickListener( this );					btnFactorial.setOnClickListener( this );
		btnFloor.setOnClickListener( this );					btnRound.setOnClickListener( this );				btnCeil.setOnClickListener( this );
		btnPow2.setOnClickListener( this );						btnPow3.setOnClickListener( this );					btnBy10Pow.setOnClickListener( this );
		btnRoot2.setOnClickListener( this );					btnRoot3.setOnClickListener( this );				btnRoot.setOnClickListener( this );
		btnExp.setOnClickListener( this );						btnExp10.setOnClickListener( this );				btnPow.setOnClickListener( this );
		btnLn.setOnClickListener( this );						btnLog10.setOnClickListener( this );				btnLog.setOnClickListener( this );
		btnSin.setOnClickListener( this );						btnCos.setOnClickListener( this );					btnTan.setOnClickListener( this );
		btnArcSin.setOnClickListener( this );					btnArcCos.setOnClickListener( this );				btnArcTan.setOnClickListener( this );
		btnSinh.setOnClickListener( this );						btnCosh.setOnClickListener( this );					btnTanh.setOnClickListener( this );
		btnArcSinh.setOnClickListener( this );					btnArcCosh.setOnClickListener( this );				btnArcTanh.setOnClickListener( this );
		btnHypot.setOnClickListener( this );					btnAtan2.setOnClickListener( this );				btnXpowX.setOnClickListener( this );
		btnLambertW_1.setOnClickListener( this );				btnLambertW.setOnClickListener( this );				btnInvXpowX.setOnClickListener( this );
	}

	@Override
	public void onClick(View v) {
		/*
		((CalculatorActivity)Cache.get( "calculatorActivity" )).exeFunction( MathFunction.listFunctions.get( position ) );
		Toasty.info( getApplicationContext(), "Fnc selected: " + arrayFncs.get( position ), Toast.LENGTH_SHORT, true ).show();
		// Close this window
		this.finish();
		*/
		CalculatorActivity calc = (CalculatorActivity)Cache.get( "calculatorActivity" );
		switch( v.getId() ){
			case R.id.btnAbs:		calc.exeFunction( MathFunction.ABS );				break;
			case R.id.btnMod:		calc.exeFunction( MathFunction.MOD );				break;
			case R.id.btnInverse:	calc.exeFunction( MathFunction.INV );				break;
			case R.id.btnRad:		calc.exeFunction( MathFunction.RAD );				break;
			case R.id.btnDeg:		calc.exeFunction( MathFunction.DEG );				break;
			case R.id.btnFactorial:	calc.exeFunction( MathFunction.FACTORIAL );			break;
			case R.id.btnFloor:		calc.exeFunction( MathFunction.FLOOR );				break;
			case R.id.btnRound:		calc.exeFunction( MathFunction.ROUND );				break;
			case R.id.btnCeil:		calc.exeFunction( MathFunction.CEIL );				break;
			case R.id.btnPow2:		calc.exeFunction( MathFunction.POW2 );				break;
			case R.id.btnPow3:		calc.exeFunction( MathFunction.POW3 );				break;
			case R.id.btnBy10Pow:	calc.exeFunction( MathFunction.BY10POW );			break;
			case R.id.btnRoot2:		calc.exeFunction( MathFunction.ROOT2 );				break;
			case R.id.btnRoot3:		calc.exeFunction( MathFunction.ROOT3 );				break;
			case R.id.btnRoot:		calc.exeFunction( MathFunction.ROOT );				break;
			case R.id.btnExp:		calc.exeFunction( MathFunction.EXP );				break;
			case R.id.btnExp10:		calc.exeFunction( MathFunction.EXP10 );				break;
			case R.id.btnPow:		calc.exeFunction( MathFunction.POW );				break;
			case R.id.btnLn:		calc.exeFunction( MathFunction.LN );				break;
			case R.id.btnLog10:		calc.exeFunction( MathFunction.LOG10 );				break;
			case R.id.btnLog:		calc.exeFunction( MathFunction.LOG );				break;
			case R.id.btnSin:		calc.exeFunction( MathFunction.SIN );				break;
			case R.id.btnCos:		calc.exeFunction( MathFunction.COS );				break;
			case R.id.btnTan:		calc.exeFunction( MathFunction.TAN );				break;
			case R.id.btnArcSin:	calc.exeFunction( MathFunction.ARCSIN );			break;
			case R.id.btnArcCos:	calc.exeFunction( MathFunction.ARCCOS );			break;
			case R.id.btnArcTan:	calc.exeFunction( MathFunction.ARCTAN );			break;
			case R.id.btnSinh:		calc.exeFunction( MathFunction.SINH );				break;
			case R.id.btnCosh:		calc.exeFunction( MathFunction.COSH );				break;
			case R.id.btnTanh:		calc.exeFunction( MathFunction.TANH );				break;
			case R.id.btnArcSinh:	calc.exeFunction( MathFunction.ARCSINH );			break;
			case R.id.btnArcCosh:	calc.exeFunction( MathFunction.ARCCOSH );			break;
			case R.id.btnArcTanh:	calc.exeFunction( MathFunction.ARCTANH );			break;
			case R.id.btnHypot:		calc.exeFunction( MathFunction.HYPOT );				break;
			case R.id.btnAtan2:		calc.exeFunction( MathFunction.ATAN2 );				break;
			case R.id.btnXpowX:		calc.exeFunction( MathFunction.XPOWX );				break;
			case R.id.btnLambertW_1:calc.exeFunction( MathFunction.LAMBERTW_1 );		break;
			case R.id.btnLambertW:	calc.exeFunction( MathFunction.LAMBERTW );			break;
			case R.id.btnInvXpowX:	calc.exeFunction( MathFunction.INV_XPOWX );			break;
		}
		// Close this window
		this.finish();
	}
}
