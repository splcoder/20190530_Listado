package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class ArcTanh extends Function {

	public ArcTanh(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.ARCTANH;
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
				return 0.5*Math.log( (1.0 + aux) / (1.0 - aux) );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "arctanh(" + aArguments[ 0 ].toString() + ")";
		}
		return "arctanh(";	// 0
	}
}
