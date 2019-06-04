package com.example.a2019_05_30_listado.data;

public enum Priority {
	URGENT
	, IMPORTANT
	, NORMAL;

	public static int getIndex( Priority p ){
		switch( p ){
			case URGENT:	return 0;
			case IMPORTANT:	return 1;
			case NORMAL:	return 2;
		}
		return -1;
	}
}