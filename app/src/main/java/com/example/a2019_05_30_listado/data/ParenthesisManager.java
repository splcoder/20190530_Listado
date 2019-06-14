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

	// TODO use ArrayList: operator-number-function
	private ArrayList<MemberOperation> operations = new ArrayList<>();

	public ParenthesisManager(){
	}
}
