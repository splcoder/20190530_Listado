package com.example.a2019_05_30_listado.data.fncs.base;

import java.util.ArrayList;

public class Parenthesis extends FncBase {

	private ArrayList<FncBase> aOperations = new ArrayList<>();
	private FncBase currentFunction = null;

	public Parenthesis( FncBase parent ){
		this.parent = parent;
		this.type = FncBase.PARENTHESIS;
	}

	public void add( FncBase valOpeFnc ){
		// TODO checks...
		aOperations.add( valOpeFnc );
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
		return "";
	}
}
