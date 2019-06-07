package com.example.a2019_05_30_listado.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2019_05_30_listado.R;
import com.example.a2019_05_30_listado.activities.PopupFncActivity;
import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.MemVar;
import com.example.a2019_05_30_listado.helpers.Cache;
import com.example.a2019_05_30_listado.helpers.ClipboardHelper;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

// TODO use MS and MR for saving/retrieving constants (as a list) <<< with long click
// TODO paste from clickboard (with MR...)

// TODO for () and user's functions >>> use ArrayList: operator-number-function
public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

	CalculatorActivity that = this;

	TextView txtValue, txtOperation;
	Button btnMR, btnMS, btnC, btnBack;
	Button btnFnc;
	Button btnSum, btnSubstract, btnMultiplication, btnDivision;
	Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnPM, btnComa, btnEqual;

	private final char cComa = '.';
	private final String sComa = ".";
	private double rValue	= 0;
	private double rMemory	= 0;							// <<< Fast Mem (accessed by a click)
	private ArrayList<MemVar> aMemory = new ArrayList<>();	// <<< accessed by a "long click"
	private char cOperation = '?';	// <<< No operation
	private boolean bOperationExecuted = false;
	private MathFunction mathFunction = MathFunction.SIN;

	public ArrayList<MemVar> getMemory(){ return aMemory; }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		txtValue	= findViewById( R.id.txtValue );	txtOperation	= findViewById( R.id.txtOperation );
		btnMR		= findViewById( R.id.btnMR );		btnMS			= findViewById( R.id.btnMS );			btnC				= findViewById( R.id.btnC );				btnBack		= findViewById( R.id.btnBack );
		btnFnc		= findViewById( R.id.btnFnc );
		btnSum		= findViewById( R.id.btnSum );		btnSubstract	= findViewById( R.id.btnSubstract );	btnMultiplication	= findViewById( R.id.btnMultiplication );	btnDivision	= findViewById( R.id.btnDivision );
		btn0 = findViewById( R.id.btn0 ); btn1 = findViewById( R.id.btn1 ); btn2 = findViewById( R.id.btn2 ); btn3 = findViewById( R.id.btn3 ); btn4 = findViewById( R.id.btn4 );
		btn5 = findViewById( R.id.btn5 ); btn6 = findViewById( R.id.btn6 ); btn7 = findViewById( R.id.btn7 ); btn8 = findViewById( R.id.btn8 ); btn9 = findViewById( R.id.btn9 );
		btnPM = findViewById( R.id.btnPM );		btnComa = findViewById( R.id.btnComa );		btnEqual = findViewById( R.id.btnEqual );

		btnMR.setOnClickListener( this );				btnMS.setOnClickListener( this );						btnC.setOnClickListener( this );								btnBack.setOnClickListener( this );
		btnFnc.setOnClickListener( this );
		btnSum.setOnClickListener( this );				btnSubstract.setOnClickListener( this );				btnMultiplication.setOnClickListener( this );					btnDivision.setOnClickListener( this );
		btn0.setOnClickListener( this ); btn1.setOnClickListener( this ); btn2.setOnClickListener( this ); btn3.setOnClickListener( this ); btn4.setOnClickListener( this );
		btn5.setOnClickListener( this ); btn6.setOnClickListener( this ); btn7.setOnClickListener( this ); btn8.setOnClickListener( this ); btn9.setOnClickListener( this );
		btnPM.setOnClickListener( this );		btnComa.setOnClickListener( this );			btnEqual.setOnClickListener( this );

		// Long Click
		btnFnc.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				//Intent intent = new Intent( getApplicationContext(), PopupBasicFncsActivity.class );
				Intent intent = new Intent( getApplicationContext(), PopupFncActivity.class );
				Cache.set( "calculatorActivity", that );
				startActivity( intent );
				//return false;		// <<< onClick will be executed too
				return true;		// <<< Only onLongClick will be executed
			}
		});

		txtValue.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				ClipboardHelper.setText( txtValue.getText().toString(), getApplicationContext() );
				Toasty.info( getApplicationContext(), "Copied to clipboard.", Toast.LENGTH_SHORT, true ).show();
				//return false;		// <<< onClick will be executed too
				return true;		// <<< Only onLongClick will be executed
			}
		});

		btnMR.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Intent intent = new Intent( getApplicationContext(), PopupMemActivity.class );
				Cache.set( "calculatorActivity", that );
				startActivity( intent );
				//return false;		// <<< onClick will be executed too
				return true;		// <<< Only onLongClick will be executed
			}
		});

		btnMS.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Intent intent = new Intent( getApplicationContext(), PopupMemSaveActivity.class );
				Cache.set( "calculatorActivity", that );
				Cache.set( "value", txtValue.getText().toString() );
				startActivity( intent );
				//return false;		// <<< onClick will be executed too
				return true;		// <<< Only onLongClick will be executed
			}
		});
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	private void resetOperationsTo( int number ) {
		txtValue.setText( "" + number );
		rValue = 0;
		cOperation = '?';
		txtOperation.setText( "" );
		bOperationExecuted = false;
	}
	private void clickedNumeric( int number ) {
		if( bOperationExecuted ) {
			resetOperationsTo( number );
			//bOperationExecuted = false;	<<< DONE
		}
		else {
			if( number == 0 ) {
				if( ! txtValue.getText().equals( "0" ) )
					txtValue.setText( txtValue.getText() + "0" );
			}
			else {
				if( txtValue.getText().equals( "0" ) )
					txtValue.setText( "" + number );
				else	txtValue.setText( txtValue.getText().toString() + number );
			}
		}
	}
	private void clickedOperation( char operation ) {
		bOperationExecuted = false;
		if( cOperation == '?' ) {
			if( rValue == 0 ) {
				rValue = Double.parseDouble( txtValue.getText().toString() );
			}
			txtValue.setText( "0" );
		}
		cOperation = operation;
		txtOperation.setText( "" + rValue + " " + operation );
	}
	private void exeOperation( char operation, double arg2 ){
		switch( cOperation ) {
			case '+': {
				rValue += arg2;
				bOperationExecuted = true;
				break;
			}
			case '-': {
				rValue -= arg2;
				bOperationExecuted = true;
				break;
			}
			case '*': {
				rValue *= arg2;
				bOperationExecuted = true;
				break;
			}
			case '/': {
				if( Double.isNaN( rValue ) || Double.isNaN( arg2 ) )	rValue = Double.NaN;
				else{
					rValue /= arg2;
					// Check 0/0
					if( Double.isNaN( rValue ) )	rValue = 1;
				}
				bOperationExecuted = true;
				break;
			}
			case 'f': {
				rValue = MathFunction.exeFunction( mathFunction, rValue, arg2 );
				bOperationExecuted = true;
				break;
			}
			default:;
		}
	}
	public void exeFunction( MathFunction mf ){
		// TODO check if ok
		if( MathFunction.isOneArgumentFunction( mf ) ){
			// --- As btnEqual ---
			if( bOperationExecuted ){
				rValue = MathFunction.exeFunction( mf, rValue );
				//bOperationExecuted = true;
			}
			else{
				double rAux = Double.parseDouble( txtValue.getText().toString() );
				bOperationExecuted = false;
				//exeOperation( cOperation, rAux );
				rValue = MathFunction.exeFunction( mf, rAux );	// <<<
				bOperationExecuted = true;						// <<<
			}
			if( bOperationExecuted ) {
				txtValue.setText( "" + rValue );
				txtOperation.setText( "" );
			}
			cOperation = '?';
		}
		else{
			// --- As clickedOperation() ---
			bOperationExecuted = false;
			if( cOperation == '?' ) {
				if( rValue == 0 ) {
					rValue = Double.parseDouble( txtValue.getText().toString() );
				}
				txtValue.setText( "0" );
			}
			cOperation = 'f';
			mathFunction = mf;
			txtOperation.setText( "" + rValue + " " + MathFunction.toString( mf ) );
		}
	}

	public void setValue( String value ){ txtValue.setText( value ); }
	public void setValue( double value ){ txtValue.setText( String.valueOf( value ) ); }

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnMR:	setValue( rMemory );											break;
			case R.id.btnMS:	rMemory = Double.parseDouble( txtValue.getText().toString() );	break;
			case R.id.btnC:		resetOperationsTo(0 );									break;
			case R.id.btnBack: {
				if( bOperationExecuted ){
					resetOperationsTo(0 );
				}
				else{
					String sValue = txtValue.getText().toString();
					sValue = sValue.substring( 0, sValue.length() - 1 );
					if( sValue.isEmpty() )	sValue = "0";
					txtValue.setText( sValue );
				}
				break;
			}
			case R.id.btnFnc: {
				//Intent intent = new Intent( getApplicationContext(), PopupFncActivity.class );
				Intent intent = new Intent( getApplicationContext(), PopupBasicFncsActivity.class );
				Cache.set( "calculatorActivity", that );
				startActivity( intent );
				break;
			}
			case R.id.btnDivision:			clickedOperation( '/' );							break;
			case R.id.btnMultiplication:	clickedOperation( '*' );							break;
			case R.id.btnSubstract:			clickedOperation( '-' );							break;
			case R.id.btnSum:				clickedOperation( '+' );							break;
			case R.id.btn9:					clickedNumeric(9 );							break;
			case R.id.btn8:					clickedNumeric(8 );							break;
			case R.id.btn7:					clickedNumeric(7 );							break;
			case R.id.btn6:					clickedNumeric(6 );							break;
			case R.id.btn5:					clickedNumeric(5 );							break;
			case R.id.btn4:					clickedNumeric(4 );							break;
			case R.id.btn3:					clickedNumeric(3 );							break;
			case R.id.btn2:					clickedNumeric(2 );							break;
			case R.id.btn1:					clickedNumeric(1 );							break;
			case R.id.btn0:					clickedNumeric(0 );							break;
			case R.id.btnPM: {
				if( bOperationExecuted ){
					rValue = -rValue;
					txtValue.setText( "" + rValue );
				}
				else{
					double rAux = Double.parseDouble( txtValue.getText().toString() );
					rAux = -rAux;
					txtValue.setText( "" + rAux );
				}
				break;
			}
			case R.id.btnComa: {
				String valueTxt = txtValue.getText().toString();
				if( valueTxt.length() > 1 && valueTxt.charAt( 1 ) == cComa ){ /*NOTHING TO DO*/ }
				else	txtValue.setText( valueTxt + sComa );
				break;
			}
			case R.id.btnEqual: {
				double rAux = Double.parseDouble( txtValue.getText().toString() );
				bOperationExecuted = false;
				exeOperation( cOperation, rAux );
				if( bOperationExecuted ) {
					txtValue.setText( "" + rValue );
					txtOperation.setText( "" );
				}
				cOperation = '?';
				break;
			}
		}
	}
}
