package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Tan extends Function {

	public Tan(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.TAN;
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
				return Math.tan( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "tan(" + aArguments[ 0 ].toString() + ")";
		}
		return "tan(";	// 0
	}
}
