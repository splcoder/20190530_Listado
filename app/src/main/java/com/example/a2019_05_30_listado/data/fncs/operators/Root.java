package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Root extends Operator {

	public Root( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.ROOT;
	}

	@Override
	public double output() {
		return Math.pow( left.output(), 1/right.output() );
	}

	@Override
	public String toString() {
		return "root";
	}
}