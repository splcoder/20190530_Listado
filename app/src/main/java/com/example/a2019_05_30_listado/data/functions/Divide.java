package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Divide extends Function {

	public Divide(){
		aArguments = new FunctionArgument[ 2 ];
		mathFunction = MathFunction.DIVIDE;
	}

	@Override
	public int totalArguments() {
		return 2;
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].output();
			case 2: return aArguments[ 0 ].output() / aArguments[ 1 ].output();
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].toString() + " / ";
			case 2: return aArguments[ 0 ].toString() + " / " + aArguments[ 1 ].toString();
		}
		return "";	// 0
	}
}