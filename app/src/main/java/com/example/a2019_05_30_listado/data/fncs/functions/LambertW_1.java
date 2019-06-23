package com.example.a2019_05_30_listado.data.fncs.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Function;
import com.example.a2019_05_30_listado.data.fncs.base.Value;

public class LambertW_1 extends Function {

	public LambertW_1( FncBase parent ){
		super( parent );
		aArguments = new Value[ 1 ];
		mathFunction = MathFunction.LAMBERTW_1;
	}

	@Override
	public int totalArguments() {
		return 1;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	{
				return MathFunction.lambertW1( aArguments[ 0 ].output() );
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return "lambw_1(" + aArguments[ 0 ].toString() + ")";
		}
		return "lambw_1(";	// 0
	}
}