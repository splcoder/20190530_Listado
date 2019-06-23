package com.example.a2019_05_30_listado.data.fncs.base;

import com.example.a2019_05_30_listado.data.MathFunction;

import java.util.ArrayList;

/**
 * Multi size arguments
 */
abstract public class FunctionMA extends FncBase {

	protected FncBase[] aArguments;		// TODO <<< DELETE THIS ARRAY
	//protected ArrayList<FncBase> aArguments = new ArrayList<>();
	protected int totalArgumentsFilled = 0;

	protected MathFunction mathFunction;	// Function Type

	protected FunctionMA(FncBase parent ){
		this.parent = parent;
		this.type = FncBase.FUNCTION_MA;
	}

	public abstract int totalArguments();

	public abstract double output();
	public abstract String toString();

	// Set argument to this function
	public void set( FncBase arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set argument in bad position: " + position );
		aArguments[ position ] = arg;
	}

	// TODO ... delLast ...

	public int getTotalArgumentsFilled(){ return totalArgumentsFilled; }
	public int getAndIncrementTotalArgumentsFilled(){ return totalArgumentsFilled++; }
	public boolean delLastArgument(){
		if( totalArgumentsFilled == 0 )	return false;
		aArguments[ --totalArgumentsFilled ] = null;
		return true;
	}
}