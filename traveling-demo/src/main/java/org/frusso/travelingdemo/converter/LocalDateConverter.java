package org.frusso.travelingdemo.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		
		if (date == null)
			return null;
		
		return Date.valueOf(date);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		
		if (value == null)
			return null;
		
		return value.toLocalDate();
	}

}
