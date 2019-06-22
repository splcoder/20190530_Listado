package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Exp10 extends Function {

	public Exp10(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.EXP10;
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
				return Math.pow( 10, aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "10^(" + aArguments[ 0 ].toString() + ")";
		}
		return "10^(";	// 0
	}
}