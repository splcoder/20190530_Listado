package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Exp extends Function {

	public Exp(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.EXP;
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
				return Math.exp( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "exp(" + aArguments[ 0 ].toString() + ")";
		}
		return "exp(";	// 0
	}
}