package com.example.a2019_05_30_listado.data.fncs.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Function;
import com.example.a2019_05_30_listado.data.fncs.base.Value;
import com.example.a2019_05_30_listado.helpers.Chars;

public class Divide extends Function {

	public Divide( FncBase parent ){
		super( parent );
		aArguments = new Value[ 2 ];
		mathFunction = MathFunction.DIVIDE;
	}

	@Override
	public int totalArguments() {
		return 2;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].output();
			case 2: return aArguments[ 0 ].output() / aArguments[ 1 ].output();
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].toString() + Chars.NBSPACE + "/" + Chars.NBSPACE;
			case 2: return aArguments[ 0 ].toString() + Chars.NBSPACE + "/" + Chars.NBSPACE + aArguments[ 1 ].toString();
		}
		return "";	// 0
	}
}