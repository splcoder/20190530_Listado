package com.example.a2019_05_30_listado.data.fncs.base;

import com.example.a2019_05_30_listado.data.MathFunction;

abstract public class Operator extends FncBase {

	public void setParent( FncBase parent ){
		this.parent = parent;
	}

	protected MathFunction mathFunction;	// Function Type

	protected Operator( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.OPERATOR;
	}

	public abstract double output( FncBase left, FncBase right );

	public abstract double output();
	public abstract String toString();
}