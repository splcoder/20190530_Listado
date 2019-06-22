package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.helpers.Chars;

public class XpowX extends Function {

	public XpowX(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.XPOWX;
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
			case 1:	return Math.pow( aArguments[ 0 ].output(), aArguments[ 0 ].output() );
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "(" + aArguments[ 0 ].toString() + Chars.NBSPACE + "^" + Chars.NBSPACE + aArguments[ 0 ].toString() + ")";
		}
		return "";	// 0
	}
}
