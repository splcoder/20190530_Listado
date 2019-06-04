package com.example.a2019_05_30_listado.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MathFunction {
	MOD, INV /* 1/x */, RAD /* to rad */, DEG /* to degrees*/, FACTORIAL
	, FLOOR, ROUND, CEIL, ABS
	, POW2, POW3, POW, ROOT2, ROOT3, ROOT
	, EXP, LN, EXP10, LOG10, LOG
	, SIN, COS, TAN, ARCSIN, ARCCOS, ARCTAN
	, SINH, COSH, TANH, ARCSINH, ARCCOSH, ARCTANH
	;

	// = MathFunction.values()
	public static final List<MathFunction> listFunctions = new ArrayList<MathFunction>(
		Arrays.asList(
			MOD, INV /* 1/x */, RAD /* to rad */, DEG /* to degrees*/, FACTORIAL
			, FLOOR, ROUND, CEIL, ABS
			, POW2, POW3, POW, ROOT2, ROOT3, ROOT
			, EXP, LN, EXP10, LOG10, LOG
			, SIN, COS, TAN, ARCSIN, ARCCOS, ARCTAN
			, SINH, COSH, TANH, ARCSINH, ARCCOSH, ARCTANH
		)
	);

	public static boolean isOneArgumentFunction( MathFunction mf ){
		switch( mf ){
			case MOD:
			case POW:
			case ROOT:
			case LOG:
				return false;
			default:;
		}
		return true;
	}

	public static String toString( MathFunction mf ){
		switch( mf ){
			case MOD:		return "mod";
			case INV:		return "inv";
			case RAD:		return "rad";
			case DEG:		return "deg";
			case FACTORIAL:	return "factorial";
			case FLOOR:		return "floor";
			case ROUND:		return "round";
			case CEIL:		return "ceil";
			case ABS:		return "abs";
			case POW2:		return "pow2";
			case POW3:		return "pow3";
			case POW:		return "pow";
			case ROOT2:		return "root2";
			case ROOT3:		return "root3";
			case ROOT:		return "root";
			case EXP:		return "exp";
			case LN:		return "ln";
			case EXP10:		return "exp10";
			case LOG10:		return "log10";
			case LOG:		return "log";
			case SIN:		return "sin";
			case COS:		return "cos";
			case TAN:		return "tan";
			case ARCSIN:	return "arcsin";
			case ARCCOS:	return "arccos";
			case ARCTAN:	return "arctan";
			case SINH:		return "sinh";
			case COSH:		return "cosh";
			case TANH:		return "tanh";
			case ARCSINH:	return "arcsinh";
			case ARCCOSH:	return "arccosh";
			case ARCTANH:	return "arctanh";
		}
		return "";
	}

	public static double exeFunction( MathFunction mf, double arg1, double arg2 ){
		switch( mf ){
			case MOD:		return arg1 % arg2;
			case INV:		return 1/arg1;
			case RAD:		return arg1*Math.PI/180;
			case DEG:		return arg1*180/Math.PI;
			case FACTORIAL:	return Math.pow( arg1, arg1 )*Math.exp( -arg1 )*Math.sqrt( arg1*2*Math.PI + 1 );
			case FLOOR:		return Math.floor( arg1 );
			case ROUND:		return Math.round( arg1 );
			case CEIL:		return Math.ceil( arg1 );
			case ABS:		return Math.abs( arg1 );
			case POW2:		return arg1 * arg1;
			case POW3:		return arg1 * arg1 * arg1;
			case POW:		return Math.pow( arg1, arg2 );
			case ROOT2:		return Math.sqrt( arg1 );
			case ROOT3:		return Math.cbrt( arg1 );
			case ROOT:		return Math.pow( arg1, 1/arg2 );
			case EXP:		return Math.exp( arg1 );
			case LN:		return Math.log( arg1 );
			case EXP10:		return Math.pow( 10, arg1 );
			case LOG10:		return Math.log10( arg1 );
			case LOG:		return Math.log( arg1 ) / Math.log( arg2 );
			case SIN:		return Math.sin( arg1 );
			case COS:		return Math.cos( arg1 );
			case TAN:		return Math.tan( arg1 );
			case ARCSIN:	return Math.asin( arg1 );
			case ARCCOS:	return Math.acos( arg1 );
			case ARCTAN:	return Math.atan( arg1 );
			case SINH:		return Math.sinh( arg1 );
			case COSH:		return Math.cosh( arg1 );
			case TANH:		return Math.tanh( arg1 );
			case ARCSINH:	return Math.log( arg1 + Math.sqrt( arg1*arg1 + 1.0 ) );
			case ARCCOSH:	return Math.log( arg1 + Math.sqrt( arg1*arg1 - 1.0 ) );
			case ARCTANH:	return 0.5*Math.log( (arg1 + 1.0) / (arg1 - 1.0) );
		}
		return 0;
	}
	public static double exeFunction( MathFunction mf, double arg1 ){
		return exeFunction( mf, arg1, 0 );
	}
}
