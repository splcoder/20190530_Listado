package com.example.a2019_05_30_listado.data;

import java.io.Serializable;

public class MemVar implements Serializable {
	private double value = 0;
	private String name = "";
	public MemVar(){}

	public MemVar( double value, String name ) {
		this.value = value;
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + value;
	}

	public String toStringAll() {
		return "MemVar{" +
				"value=" + value +
				", name='" + name + '\'' +
				'}';
	}
}
