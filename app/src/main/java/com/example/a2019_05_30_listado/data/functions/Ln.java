package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Ln extends Function {

	public Ln(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.LN;
	}

	@Override
	public int totalArguments() {
		return 1;
	}

	@Override
	public boolean isOperator() {
		return false;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	{
				return Math.log( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "ln(" + aArguments[ 0 ].toString() + ")";
		}
		return "ln(";	// 0
	}
}