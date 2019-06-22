package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class LambertW extends Function {

	public LambertW(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.LAMBERTW;
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
				return MathFunction.lambertW( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "lambw(" + aArguments[ 0 ].toString() + ")";
		}
		return "lambw(";	// 0
	}
}
