package br.edu.ifbaiano.homines.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.ifbaiano.homines.domain.model.SituationEnum;

@Converter(autoApply = true)
public class SituationConverter implements AttributeConverter<SituationEnum, String>{

	SituationEnum situationEnum;
	
	@Override
	public String convertToDatabaseColumn(SituationEnum situation) {
		return situation.getDescription();
	}

	@Override
	public SituationEnum convertToEntityAttribute(String dbData) {

		return Stream.of(SituationEnum.values())
				.filter(s -> s.getDescription().equals(dbData))
				.findFirst()
				.orElse(situationEnum);
	}

}
