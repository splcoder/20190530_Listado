package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Log10 extends Function {

	public Log10(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.LOG10;
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
				return Math.log10( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "log10(" + aArguments[ 0 ].toString() + ")";
		}
		return "log10(";	// 0
	}
}
