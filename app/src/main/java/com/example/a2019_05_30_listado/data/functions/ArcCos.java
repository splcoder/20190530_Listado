package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class ArcCos extends Function {

	public ArcCos(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.ARCCOS;
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
				return Math.acos( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "arccos(" + aArguments[ 0 ].toString() + ")";
		}
		return "arccos(";	// 0
	}
}