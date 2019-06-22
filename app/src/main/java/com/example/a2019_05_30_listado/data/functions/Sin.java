package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Sin extends Function {

	public Sin(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.SIN;
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
				return Math.sin( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "sin(" + aArguments[ 0 ].toString() + ")";
		}
		return "sin(";	// 0
	}
}