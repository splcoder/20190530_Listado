package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Deg extends Function {

	public Deg(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.DEG;
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
			case 1:	return aArguments[ 0 ].output()*180./Math.PI;
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "deg(" + aArguments[ 0 ].toString() + ")";
		}
		return "deg(";	// 0
	}
}
