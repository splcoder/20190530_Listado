package com.example.a2019_05_30_listado.data.functions;

import java.util.ArrayList;

/**
 * This class will control all the calculation
 */
public class OperationsControler extends Function {		// TODO create similar class Parenthesis ???

	private ArrayList<FunctionArgument> aOperations = new ArrayList<>();
	private Function currentFunction = this;

	public OperationsControler(){}

	public void add( Function arg ){
		// TODO
		aOperations.add( new FunctionArgument( this, arg ) );
		currentFunction = arg;	// TODO ???
	}
	public void add( double arg ){
		// TODO
		aOperations.add( new FunctionArgument( this, arg ) );
	}
	public void add( String arg ){
		// TODO
		aOperations.add( new FunctionArgument( this, arg ) );
	}
	public void add( Constant arg ){
		// TODO
		aOperations.add( new FunctionArgument( this, arg ) );
	}

	public void delLast(){
		// TODO
	}

	@Override
	public int totalArguments() {
		return aOperations.size();
	}

	@Override
	public boolean isOperator() {
		return false;
	}

	@Override
	public double output() {
		// TODO
		return 0;
	}

	@Override
	public String toString() {
		// TODO
		return "";
	}
}
