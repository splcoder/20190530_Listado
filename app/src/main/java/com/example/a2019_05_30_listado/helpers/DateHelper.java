package com.example.a2019_05_30_listado.helpers;

import java.util.Calendar;

public class DateHelper {

	public static long getTimeMilis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	public static String getDate( long date, boolean showHour ) {
		String sDate = "";
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis( date );
		int month = c.get( Calendar.MONTH ) + 1;
		int day = c.get( Calendar.DATE );
		sDate += c.get( Calendar.YEAR ) + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
		if( showHour ) {
			int hours = c.get( Calendar.HOUR_OF_DAY );
			int minutes = c.get( Calendar.MINUTE );
			int seconds = c.get( Calendar.SECOND );
			sDate += " " + (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds);
		}
		return sDate;
	}
}
