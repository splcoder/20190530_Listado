package com.example.a2019_05_30_listado.data.fncs.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Function;
import com.example.a2019_05_30_listado.data.fncs.base.Value;

public class Ceil extends Function {

	public Ceil( FncBase parent ){
		super( parent );
		aArguments = new Value[ 1 ];
		mathFunction = MathFunction.CEIL;
	}

	@Override
	public int totalArguments() {
		return 1;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	{
				return Math.ceil( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "ceil(" + aArguments[ 0 ].toString() + ")";
		}
		return "ceil(";	// 0
	}
}