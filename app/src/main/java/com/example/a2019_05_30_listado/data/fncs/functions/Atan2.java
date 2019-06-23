package com.example.a2019_05_30_listado.data.fncs.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Function;
import com.example.a2019_05_30_listado.data.fncs.base.Value;
import com.example.a2019_05_30_listado.helpers.Chars;

public class Atan2 extends Function {

	public Atan2( FncBase parent ){
		super( parent );
		aArguments = new Value[ 2 ];
		mathFunction = MathFunction.ATAN2;
	}

	@Override
	public int totalArguments() {
		return 2;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].output();
			case 2: return Math.atan2( aArguments[ 1 ].output(), aArguments[ 0 ].output() );
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].toString() + Chars.NBSPACE + "atan2" + Chars.NBSPACE;
			case 2: return aArguments[ 0 ].toString() + Chars.NBSPACE + "atan2" + Chars.NBSPACE + aArguments[ 1 ].toString();
		}
		return "";	// 0
	}
}