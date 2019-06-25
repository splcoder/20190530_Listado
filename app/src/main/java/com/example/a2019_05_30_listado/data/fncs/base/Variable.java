package com.example.a2019_05_30_listado.data.fncs.base;

import static com.example.a2019_05_30_listado.data.fncs.base.Constant.NO_CONSTANT;

public class Variable extends FncBase {

	private double value = 0;
	private String sValue = "0";
	private Constant constant = NO_CONSTANT;	// For showing: Pi, e, ..., instead of its value

	private String name = "X";
	public void setName( String name ){
		this.name = name;
	}

	private Variable( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.VALUE;
		setNoArgument();
	}

	public Variable( FncBase parent, double value ){
		this( parent );
		this.value = value;
		this.sValue = String.valueOf( value );
	}
	public Variable( FncBase parent, double value, String name ){
		this( parent, value );
		this.name = name;
	}

	public Variable( FncBase parent, String number ){
		this( parent );
		this.value = Double.parseDouble( number );
		this.sValue = number;
	}
	public Variable( FncBase parent, String number, String name ){
		this( parent, number );
		this.name = name;
	}

	public Variable( FncBase parent, Constant constant ){
		this( parent );
		this.constant = constant;
		this.value = Constant.get( constant );
		this.sValue = Constant.toString( constant );
	}
	public Variable( FncBase parent, Constant constant, String name ){
		this( parent, constant );
		this.name = name;
	}

	public boolean isConstant(){ return constant != NO_CONSTANT; }

	@Override
	public double output(){ return value; }
	@Override
	public String toString(){ return name; }
}
