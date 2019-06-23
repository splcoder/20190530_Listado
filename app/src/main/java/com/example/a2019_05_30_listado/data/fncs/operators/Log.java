package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

public class Log extends Operator {

	public Log( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.LOG;
	}

	@Override
	public double output() {
		return Math.log( left.output() ) / Math.log( right.output() );
	}

	@Override
	public String toString() {
		return "log";
	}
}