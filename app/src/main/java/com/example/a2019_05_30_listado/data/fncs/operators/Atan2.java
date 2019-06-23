package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Atan2 extends Operator {

	public Atan2( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.ATAN2;
	}

	@Override
	public double output() {
		return Math.atan2( right.output(), left.output() );
	}

	@Override
	public String toString() {
		return "atan2";
	}
}