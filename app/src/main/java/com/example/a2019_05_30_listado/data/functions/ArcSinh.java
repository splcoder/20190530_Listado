package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class ArcSinh extends Function {

	public ArcSinh(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.ARCSINH;
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
				return Math.log( aux + Math.sqrt( aux*aux + 1.0 ) );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "arcsinh(" + aArguments[ 0 ].toString() + ")";
		}
		return "arcsinh(";	// 0
	}
}
