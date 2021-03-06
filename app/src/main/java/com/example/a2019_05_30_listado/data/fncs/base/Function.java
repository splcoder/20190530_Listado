package com.example.a2019_05_30_listado.data.fncs.base;

import com.example.a2019_05_30_listado.data.MathFunction;

/**
 * Fixed size arguments
 */
abstract public class Function extends FncBase {

	protected FncBase[] aArguments;
	protected int totalArgumentsFilled = 0;	// = comas set

	protected MathFunction mathFunction;	// Function Type

	protected Function( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.FUNCTION;
	}

	public abstract int totalArguments();

	public abstract double output();
	public abstract String toString();

	public boolean thereIsSpaceForMoreArguments(){ return totalArgumentsFilled < totalArguments(); }
	public void add( FncBase arg ){
		if( totalArgumentsFilled >= totalArguments() )	throw new IllegalArgumentException( "Add argument: no more arguments can be added" );
		aArguments[ totalArgumentsFilled++ ] = arg;
	}
	public void set( FncBase arg, int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Set argument in bad position: " + position );
		aArguments[ position ] = arg;
	}
	public FncBase get( int position ){
		if( position < 0 || position >= totalArguments() )	throw new IllegalArgumentException( "Get argument in bad position: " + position );
		return aArguments[ position ];
	}

	public int getTotalArgumentsFilled(){ return totalArgumentsFilled; }
	public int getAndIncrementTotalArgumentsFilled(){ return totalArgumentsFilled++; }
	public void incrementTotalArgumentsFilled(){ totalArgumentsFilled++; }
	public boolean delLastArgument(){
		if( totalArgumentsFilled == 0 )	return false;
		aArguments[ --totalArgumentsFilled ] = null;
		return true;
	}
}
