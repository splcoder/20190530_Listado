package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

abstract public class Function {

	//FunctionArgument parent = null;			// If != null, this Function will be a FunctionArgument of another Function

	protected FunctionArgument[] aArguments;
	protected int totalArgumentsFilled = 0;

	protected MathFunction mathFunction;	// Function Type

	public abstract int totalArguments();
	public abstract boolean isOperator();	// +,-,*,/,...
	public abstract double output();
	public abstract String toString();

	// Set argument to this function
	public void set( Function arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set Function in position: " + position );
		aArguments[ position ] = new FunctionArgument( this, arg );
	}
	public void set( double arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set double in position: " + position );
		aArguments[ position ] = new FunctionArgument( this, arg );
	}
	public void set( String arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set String number in position: " + position );
		aArguments[ position ] = new FunctionArgument( this, arg );
	}
	public void set( Constant arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set Constant in position: " + position );
		aArguments[ position ] = new FunctionArgument( this, arg );
	}

	public int getTotalArgumentsFilled(){ return totalArgumentsFilled; }
	public int getAndIncrementTotalArgumentsFilled(){ return totalArgumentsFilled++; }
	public boolean delLastArgument(){
		if( totalArgumentsFilled == 0 )	return false;
		aArguments[ --totalArgumentsFilled ] = null;
		return true;
	}
}
