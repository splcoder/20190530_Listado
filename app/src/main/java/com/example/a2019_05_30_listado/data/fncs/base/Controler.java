package com.example.a2019_05_30_listado.data.fncs.base;

import java.util.ArrayList;

/**
 * This class will control all the calculation
 */
// TODO for () and user's functions
// TODO on () change '=' to ','
	// TODO if there is a composition of functions-functionMAs-Parenthesis, the last will be a Value (at least)

// TODO MEJOR: que Controle sea un Parenthesis O QUE CONTENGA UN PARENTHESIS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class Controler extends FncBase {	// <<< Really it is not required to extends from FncBase

	private ArrayList<FncBase> aOperations = new ArrayList<>();
	private FncBase currentFunction = null;
	private int totalParenthesisOpened = 0;
	public boolean areParenthesisOpened(){ return totalParenthesisOpened > 0; }

	private double rResult = 0;

	public Controler(){}

	public void add( FncBase arg ){
		// TODO
		aOperations.add( arg );
		currentFunction = arg;	// TODO ???
	}

	public void delLast(){
		// TODO
	}

	public int totalArguments() {
		return aOperations.size();
	}

	@Override
	public double output() {
		// TODO
		return 0;
	}

	@Override
	public String toString() {
		// TODO
		return "";
	}
}
