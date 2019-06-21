package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Factorial extends Function {

	public Factorial(){
		aArguments = new FunctionArgument[ 1 ];
		mathFunction = MathFunction.FACTORIAL;
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
				return aux < 0 ? MathFunction.reflectionFactorial( aux ) : MathFunction.factorial( aux );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "factorial(" + aArguments[ 0 ].toString() + ")";
		}
		return "factorial(";	// 0
	}
}
