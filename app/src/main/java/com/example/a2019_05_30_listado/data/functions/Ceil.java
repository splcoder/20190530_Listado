package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Ceil extends Function {

	public Ceil(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.CEIL;
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
				return Math.ceil( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "ceil(" + aArguments[ 0 ].toString() + ")";
		}
		return "ceil(";	// 0
	}
}