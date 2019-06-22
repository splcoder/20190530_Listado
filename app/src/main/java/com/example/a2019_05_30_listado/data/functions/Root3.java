package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Root3 extends Function {

	public Root3(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.ROOT3;
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
				return Math.cbrt( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "(" + aArguments[ 0 ].toString() + ")^3";
		}
		return "";	// 0
	}
}