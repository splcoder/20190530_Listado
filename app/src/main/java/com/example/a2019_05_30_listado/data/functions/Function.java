package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

abstract public class Function {

	protected FunctionArgument[] aArguments;
	protected int totalArgumentsFilled = 0;

	protected MathFunction mathFunction;	// Function Type

	public abstract int totalArguments();
	public abstract boolean isOperator();	// +,-,*,/,...
	public abstract double output();
	public abstract String toString();
}
