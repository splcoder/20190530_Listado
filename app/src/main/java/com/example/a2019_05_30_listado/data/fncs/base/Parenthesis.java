package com.example.a2019_05_30_listado.data.fncs.base;

import java.util.ArrayList;

public class Parenthesis extends FncBase {

	public static final char BRACKETS_ROUND_OPEN	= '(';
	public static final char BRACKETS_ROUND_CLOSE	= ')';
	public static final char BRACKETS_BOX_OPEN		= '[';
	public static final char BRACKETS_BOX_CLOSE		= ']';
	public static final char BRACKETS_CURLY_OPEN	= '{';
	public static final char BRACKETS_CURLY_CLOSE	= '}';

	private boolean showParenthesis = true;

	private ArrayList<FncBase> aOperations = new ArrayList<>();
	private FncBase currentFunction = null;
	public FncBase getCurrentFunction(){ return currentFunction; }

	public Parenthesis( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.PARENTHESIS;
	}

	public Parenthesis( FncBase parent, boolean showParenthesis ){
		this.parent = parent;
		this.type = FncBase.PARENTHESIS;
		this.showParenthesis = showParenthesis;
	}

	public void add( FncBase valOpeFnc ){
		// TODO checks...
		switch( valOpeFnc.getType() ){
			case FncBase.VALUE: {
				if( aOperations.size() == 0 )	aOperations.add( valOpeFnc );
				else{
					if( currentFunction != null ){
						if( currentFunction.hasArguments() ){
							//
						}
						else{
							//
						}
					}
					else{
						// Get last for checking if it is an operator...
					}
				}
				break;
			}
			case FncBase.OPERATOR: {
				break;
			}
			case FncBase.FUNCTION: {
				break;
			}
			case FncBase.FUNCTION_MA: {
				break;
			}
			case FncBase.PARENTHESIS: {
				break;
			}
		}
	}

	public void delLast(){
		// TODO
	}
	// TODO

	@Override
	public double output() {
		// TODO
		return 0;
	}

	@Override
	public String toString() {
		// TODO
		return "()";
	}
}
