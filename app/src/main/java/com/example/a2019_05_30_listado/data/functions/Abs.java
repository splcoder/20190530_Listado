package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Abs extends Function {

	public Abs(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.ABS;
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
			case 1:	return Math.abs( aArguments[ 0 ].output() );
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "abs(" + aArguments[ 0 ].toString() + ")";
		}
		return "abs(";	// 0
	}
}
