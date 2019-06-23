package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Pow extends Operator {

	public Pow( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.POW;
	}

	@Override
	public double output() {
		return Math.pow( left.output(), right.output() );
	}

	@Override
	public String toString() {
		return "pow";
	}
}