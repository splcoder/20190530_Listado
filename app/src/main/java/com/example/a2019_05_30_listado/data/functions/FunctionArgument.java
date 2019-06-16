package com.example.a2019_05_30_listado.data.functions;

import static com.example.a2019_05_30_listado.data.functions.Constant.NO_CONSTANT;

/**
 * If 'fnc' is null, then this "function argument" will be a 'double' value
 */
public class FunctionArgument {

	private Function fnc = null;				// If this is null, then this argument is a constant

	private double value = 0;
	private String sValue = "0";
	private Constant constant = NO_CONSTANT;	// For showing: Pi, e, ..., instead of its value

	public FunctionArgument( Function fnc ){
		this.fnc = fnc;
	}

	public FunctionArgument( double value ){
		this.value = value;
		this.sValue = String.valueOf( value );
	}
	public FunctionArgument( String number ){
		this.value = Double.parseDouble( number );
		this.sValue = number;
	}
	public FunctionArgument( Constant constant ){
		this.constant = constant;
		this.value = Constant.get( constant );
		this.sValue = Constant.toString( constant );
	}

	public boolean isFunction(){ return fnc != null; }
	public boolean isValue(){ return fnc == null; }
	public boolean isConstant(){ return constant != NO_CONSTANT; }

	public double output(){
		if( fnc == null )	return value;
		return fnc.output();
	}

	public String toString(){
		if( fnc == null )	return sValue;
		return fnc.toString();
	}
}
