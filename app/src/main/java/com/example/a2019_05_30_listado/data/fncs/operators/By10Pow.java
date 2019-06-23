package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class By10Pow extends Operator {

	public By10Pow( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.BY10POW;
	}

	@Override
	public double output() {
		return left.output() * Math.pow( 10, right.output() );
	}

	@Override
	public String toString() {
		return "E";
	}
}