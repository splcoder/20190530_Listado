package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Pow2 extends Function {

	public Pow2(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.POW2;
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
				double aux = aArguments[ 0 ].output();
				return aux * aux;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "(" + aArguments[ 0 ].toString() + ")^2";
		}
		return "";	// 0
	}
}