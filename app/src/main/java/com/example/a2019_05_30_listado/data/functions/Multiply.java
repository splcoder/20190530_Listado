package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.helpers.Chars;

public class Multiply extends Function {

	public Multiply(){
		aArguments = new FunctionArgument[ 2 ];
		mathFunction = MathFunction.MULTIPLY;
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
			case 2: return aArguments[ 0 ].output() * aArguments[ 1 ].output();
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].toString() + Chars.NBSPACE + "*" + Chars.NBSPACE;
			case 2: return aArguments[ 0 ].toString() + Chars.NBSPACE + "*" + Chars.NBSPACE + aArguments[ 1 ].toString();
		}
		return "";	// 0
	}
}
