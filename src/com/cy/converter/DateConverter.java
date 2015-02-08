package com.cy.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			@SuppressWarnings("rawtypes") Class toType) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		try {
			if(toType == Date.class) {
				String[] parms = (String[])value;
				return dateFormat.parse(parms[0]);
			} else if (toType == String.class) {
				Date date = (Date)value;
				return dateFormat.format(date);
			}
		} catch (Exception e) {}
		return null;
	}

}
