package com.example.a2019_05_30_listado.data.functions;

import com.example.a2019_05_30_listado.data.MathFunction;

public class Add extends Function {

	public Add(){
		aArguments = new FunctionArgument[ 2 ];
		mathFunction = MathFunction.ADD;
	}

	@Override
	public int totalArguments() {
		return 2;
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public double output() {
		return aArguments[ 0 ].output() + aArguments[ 1 ].output();
	}

	@Override
	public String toString() {
		return aArguments[ 0 ].toString() + " + " + aArguments[ 1 ].toString();
	}
}
