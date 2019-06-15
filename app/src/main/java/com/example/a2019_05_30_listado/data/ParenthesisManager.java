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

	private double rResult = 0;	// The result of aOperations (i.e. of this Parenthesis)
	private boolean bCalculated = false;
	// TODO use ArrayList: operator-number-function
	private ArrayList<MemberOperation> aOperations = new ArrayList<>();

	public ParenthesisManager(){
	}

	public double getResult(){
		if( bCalculated )	return rResult;
		return calculate();
	}

	private double calculate(){
		rResult = 0;
		bCalculated = false;
		// TODO
		bCalculated = true;
		return rResult;
	}

	@Override
	public String toString() {
		return "ParenthesisManager{" +
				"rResult=" + rResult +
				'}';
	}
}
