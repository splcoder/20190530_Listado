package com.example.a2019_05_30_listado.data.fncs.functions;

import com.example.a2019_05_30_listado.data.MathFunction;
import com.example.a2019_05_30_listado.data.fncs.base.FncBase;
import com.example.a2019_05_30_listado.data.fncs.base.Function;
import com.example.a2019_05_30_listado.data.fncs.base.Value;
import com.example.a2019_05_30_listado.helpers.Chars;

public class RandInterval extends Function {

	public RandInterval( FncBase parent ){
		super( parent );
		aArguments = new Value[ 2 ];
		mathFunction = MathFunction.RAND_INTERVAL;
	}

	@Override
	public int totalArguments() {
		return 2;
	}

	@Override
	public double output() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].output();
			case 2: {
				double min = aArguments[ 0 ].output(), max = aArguments[ 1 ].output();
				if( max < min ){
					double aux = min;
					min = max;
					max = aux;
				}
				return min + Math.random()*(max - min);
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		switch( getTotalArgumentsFilled() ){
			case 1:	return aArguments[ 0 ].toString() + Chars.NBSPACE + "rand" + Chars.NBSPACE;
			case 2: return aArguments[ 0 ].toString() + Chars.NBSPACE + "rand" + Chars.NBSPACE + aArguments[ 1 ].toString();
		}
		return "";	// 0
	}
}