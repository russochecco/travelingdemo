package org.frusso.travelingdemo.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime time) {

		if (time != null)
			return Time.valueOf(time);

		return null;

	}

	@Override
	public LocalTime convertToEntityAttribute(Time value) {

		if (value != null)
			return value.toLocalTime();

		return null;

	}

}
