package com.example.a2019_05_30_listado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

	TextView txtValue, txtOperation;
	Button btnMR, btnMS, btnC;
	Button btnSum, btnSubstract, btnMultiplication, btnDivision;
	Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnPM, btnComa, btnEqual;

	private final char cComa = '.';
	private final String sComa = ".";
	private double rValue	= 0;
	private double rMemory	= 0;
	private char cOperation = '?';	// <<< No operation
	private boolean bOperationExecuted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		// Back button on action bar
		getSupportActionBar().setDisplayHomeAsUpEnabled( true );

		txtValue	= findViewById( R.id.txtValue );	txtOperation	= findViewById( R.id.txtOperation );
		btnMR		= findViewById( R.id.btnMR );		btnMS			= findViewById( R.id.btnMS );			btnC				= findViewById( R.id.btnC );
		btnSum		= findViewById( R.id.btnSum );		btnSubstract	= findViewById( R.id.btnSubstract );	btnMultiplication	= findViewById( R.id.btnMultiplication );	btnDivision	= findViewById( R.id.btnDivision );
		btn0 = findViewById( R.id.btn0 ); btn1 = findViewById( R.id.btn1 ); btn2 = findViewById( R.id.btn2 ); btn3 = findViewById( R.id.btn3 ); btn4 = findViewById( R.id.btn4 );
		btn5 = findViewById( R.id.btn5 ); btn6 = findViewById( R.id.btn6 ); btn7 = findViewById( R.id.btn7 ); btn8 = findViewById( R.id.btn8 ); btn9 = findViewById( R.id.btn9 );
		btnPM = findViewById( R.id.btnPM );		btnComa = findViewById( R.id.btnComa );		btnEqual = findViewById( R.id.btnEqual );

		btnMR.setOnClickListener( this );				btnMS.setOnClickListener( this );						btnC.setOnClickListener( this );
		btnSum.setOnClickListener( this );				btnSubstract.setOnClickListener( this );				btnMultiplication.setOnClickListener( this );					btnDivision.setOnClickListener( this );
		btn0.setOnClickListener( this ); btn1.setOnClickListener( this ); btn2.setOnClickListener( this ); btn3.setOnClickListener( this ); btn4.setOnClickListener( this );
		btn5.setOnClickListener( this ); btn6.setOnClickListener( this ); btn7.setOnClickListener( this ); btn8.setOnClickListener( this ); btn9.setOnClickListener( this );
		btnPM.setOnClickListener( this );		btnComa.setOnClickListener( this );			btnEqual.setOnClickListener( this );
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item ) {
		switch( item.getItemId() ){
			// Back button on action bar
			case android.R.id.home: {
				this.finish();
				return true;
			}
			default:;
		}
		return super.onOptionsItemSelected( item );
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
				rValue /= arg2;
				// 0/0
				if( Double.isNaN( rValue ) )	rValue = 1;
				bOperationExecuted = true;
				break;
			}
			default:;
		}
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ){
			case R.id.btnMR:	txtValue.setText( String.valueOf( rMemory ) );					break;
			case R.id.btnMS:	rMemory = Double.parseDouble( txtValue.getText().toString() );	break;
			case R.id.btnC:		resetOperationsTo(0 );									break;
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
