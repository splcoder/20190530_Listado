package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Mod extends Operator {

	public Mod( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.MOD;
	}

	@Override
	public double output() {
		return left.output() % right.output();
	}

	@Override
	public String toString() {
		return "mod";
	}
}