package com.example.a2019_05_30_listado.data.fncs.base;

import com.example.a2019_05_30_listado.data.MathFunction;

abstract public class Operator extends FncBase {

	protected MathFunction mathFunction;	// Function Type
	public MathFunction getFunctionType(){ return mathFunction; }

	public static final int LEFT_ONLY	= -1;
	public static final int BOTH		= 0;
	public static final int RIGHT_ONLY	= 1;

	protected FncBase left = null, right = null;
	protected int argumentsRequired = BOTH;
	public void setArgumentsRequired( int req ){ this.argumentsRequired = req; }
	public int getArgumentsRequired(){ return argumentsRequired; }

	protected Operator( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.OPERATOR;
		setNoArgument();
	}

	public void set( FncBase arg, boolean left ){
		if( left )	this.left = arg;
		else		this.right = arg;
	}
	public void set( FncBase left, FncBase right ){
		this.left = left;
		this.right = right;
	}

	public abstract double output();
	public abstract String toString();
}