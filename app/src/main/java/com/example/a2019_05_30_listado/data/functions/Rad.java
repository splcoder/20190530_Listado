package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Rad extends Function {

	public Rad(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.RAD;
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
			case 1:	return aArguments[ 0 ].output()*Math.PI/180;
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "rad(" + aArguments[ 0 ].toString() + ")";
		}
		return "rad(";	// 0
	}
}
