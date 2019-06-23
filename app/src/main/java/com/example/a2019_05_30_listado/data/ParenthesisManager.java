package com.example.a2019_05_30_listado.data;

import com.example.a2019_05_30_listado.activities.CalculatorActivity;

import java.util.ArrayList;

// TODO for () and user's functions
// TODO on () change '=' to ','
public class ParenthesisManager {

	private static CalculatorActivity calculatorActivity;
	public static void setCalculatorActivity( CalculatorActivity calc ){ calculatorActivity = calc; }

	private static int totalParenthesisOpened = 0;
	public static boolean areParenthesisOpened(){ return totalParenthesisOpened > 0; }
	//private static ArrayList<ParenthesisManager> aParenthesis = new ArrayList<>();

	private double rResult = 0;	// The result of aOperations (i.e. of this Parenthesis)
	private boolean bCalculated = false;
	private ArrayList<MemberOperation> aOperations = new ArrayList<>();

	public ParenthesisManager(){
	}

	public boolean isEmpty(){ return aOperations.isEmpty(); }

	public double getResult(){
		if( bCalculated )	return rResult;
		return calculate();
	}

	private double calculate(){
		rResult = 0;
		bCalculated = false;
		for( MemberOperation m : aOperations ){
			// TODO
		}
		bCalculated = true;
		return rResult;
	}

	@Override
	public String toString() {
		if( aOperations.isEmpty() )	return "";
		String sRes = "(";
		for( MemberOperation m : aOperations ){
			// TODO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			switch( m.getType() ){
				case MEMBER_NUMBER:			sRes += " " + (double)m.getMember();								break;
				case MEMBER_OPERATOR:		sRes += " " + (char)m.getMember();									break;
				case MEMBER_FUNCTION:		sRes += " " + MathFunction.toString( (MathFunction)m.getMember() );	break;	// <<< Each function followed by an array size of N_OF_ARGS Parenthesis
				case MEMBER_PARENTHESIS:	sRes += ((ParenthesisManager)m.getMember()).toString();				break;
				case MEMBER_COMA:			sRes += ", ";														break;
			}
		}
		return sRes + " )";
	}
}
