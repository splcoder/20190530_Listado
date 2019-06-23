package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Hypot extends Operator {

	public Hypot( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.HYPOT;
	}

	@Override
	public double output() {
		return Math.hypot( left.output(), right.output() );
	}

	@Override
	public String toString() {
		return "hypot";
	}
}