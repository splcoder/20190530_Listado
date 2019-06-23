package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Rand extends Operator {

	public Rand( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.RAND_INTERVAL;
	}

	@Override
	public double output() {
		double min = left.output(), max = right.output();
		if( max < min ){
			double aux = min;
			min = max;
			max = aux;
		}
		return min + Math.random()*(max - min);
	}

	@Override
	public String toString() {
		return "rand";
	}
}