package hkins.baseplatform.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import hkins.baseplatform.util.StringUtil;

public class JsonObjectMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716897036239286733L;
	private boolean snakeCase = false;
	private String dateFormatPattern;
	
	public void setSnakeCase(boolean snakeCase) {
		this.snakeCase = snakeCase;
	}

	public void setDateFormatPattern(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
	}

	public void init() {
		setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		configure(SerializationFeature.INDENT_OUTPUT, true);
		if(this.snakeCase) {
			setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		}
		if(StringUtil.isNotEmpty(dateFormatPattern)) {
			DateFormat dataFormat = new SimpleDateFormat(this.dateFormatPattern);
			setDateFormat(dataFormat);
		}
	}
}
