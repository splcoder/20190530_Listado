package com.example.a2019_05_30_listado.data.fncs.base;

abstract public class FncBase {

	public static final int NULL				= -1;	// for Controler
	public static final int VALUE				= 0;	// double
	public static final int OPERATOR			= 1;	// Function operator: +,-,...
	public static final int FUNCTION			= 2;	// Fixed arguments function		<<< arguments separated by comas
	public static final int FUNCTION_MA			= 3;	// Multi arguments function		<<< arguments separated by comas
	public static final int PARENTHESIS			= 4;

	protected FncBase parent = null;
	public void setParent( FncBase parent ){
		this.parent = parent;
	}
	public FncBase getParent(){ return parent; }

	protected int type = NULL;
	public int getType(){ return type; }

	public abstract double output();
	public abstract String toString();
}
