package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class LambertW_1 extends Function {

	public LambertW_1(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.LAMBERTW_1;
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
				return MathFunction.lambertW1( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "lambw_1(" + aArguments[ 0 ].toString() + ")";
		}
		return "lambw_1(";	// 0
	}
}