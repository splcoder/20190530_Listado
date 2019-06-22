package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class RandMax extends Function {

	public RandMax(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.RAND_MAX;
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
				return Math.random()*aArguments[ 0 ].output();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "rand(" + aArguments[ 0 ].toString() + ")";
		}
		return "rand(";	// 0
	}
}
