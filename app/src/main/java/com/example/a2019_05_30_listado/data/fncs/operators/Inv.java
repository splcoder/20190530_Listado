package com.example.a2019_05_30_listado.data.fncs.operators;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Operator;

/**
 * Only the left arg will be used
 */
public class Inv extends Operator {

	public Inv( FncBase parent ){
		super( parent );
		this.mathFunction = MathFunction.INV;
	}

	@Override
	public double output() {
		return 1./left.output();
	}

	@Override
	public String toString() {
		return "inv";
	}
}