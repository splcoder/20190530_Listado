package com.example.a2019_05_30_listado.data.fncs.base;

import com.example.a2019_05_30_listado.data.MathFunction;

import java.util.ArrayList;

/**
 * Multi size arguments
 *
 * For statistic functions (for example)
 */
abstract public class FunctionMA extends FncBase {

	protected ArrayList<FncBase> aArguments = new ArrayList<>();

	protected MathFunction mathFunction;	// Function Type

	protected FunctionMA( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.FUNCTION_MA;
	}

	public int totalArguments(){ return aArguments.size(); }	// = totalArgumentsFilled

	public abstract double output();
	public abstract String toString();

	// Set argument to this function
	public void add( FncBase arg ){ aArguments.add( arg ); }
	public void set( FncBase arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set argument in bad position: " + position );
		aArguments.set( position, arg );
	}
	public FncBase get( int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Get argument in bad position: " + position );
		return aArguments.get( position );
	}

	public int getTotalArgumentsFilled(){ return aArguments.size(); }
	public boolean delLastArgument(){
		if( aArguments.size() == 0 )	return false;
		aArguments.remove( aArguments.size() - 1 );
		return true;
	}
}