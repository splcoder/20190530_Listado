package com.example.a2019_05_30_listado.data.fncs.base;

import static com.example.a2019_05_30_listado.data.fncs.base.Constant.NO_CONSTANT;

public class Value extends FncBase {

	private double value = 0;
	private String sValue = "0";
	private Constant constant = NO_CONSTANT;	// For showing: Pi, e, ..., instead of its value

	private Value( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.VALUE;
	}

	public Value( FncBase parent, double value ){
		this( parent );
		this.value = value;
		this.sValue = String.valueOf( value );
	}
	public Value( FncBase parent, String number ){
		this( parent );
		this.value = Double.parseDouble( number );
		this.sValue = number;
	}
	public Value( FncBase parent, Constant constant ){
		this( parent );
		this.constant = constant;
		this.value = Constant.get( constant );
		this.sValue = Constant.toString( constant );
	}

	public boolean isConstant(){ return constant != NO_CONSTANT; }

	@Override
	public double output(){ return value; }
	@Override
	public String toString(){ return sValue; }
}
