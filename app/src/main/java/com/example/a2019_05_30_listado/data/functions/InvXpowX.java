package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.helpers.Chars;

public class InvXpowX extends Function {

	public InvXpowX(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.INV_XPOWX;
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
			case 1:	return MathFunction.inverseXPowX( aArguments[ 0 ].output() );
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "ixpx(" + aArguments[ 0 ].toString() + ")";
		}
		return "ixpx(";	// 0
	}
}
