package org.frusso.travelingdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ParseData {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private ParseData() {
	}
	
	public static Date stringValue2Date(String value) {
		try {
			return sdf.parse(value);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
