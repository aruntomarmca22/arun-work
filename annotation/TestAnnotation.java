package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAnnotation {
	private static final Logger logger = LoggerFactory
			.getLogger(TestAnnotation.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MoDODBDataBean bean = new MoDODBDataBean();
		bean.setImsi("12345678909766");
		bean.setOdbic("0");
		bean.setOdbpos("NOBPOS");
		bean.setHlrsn(256);
		try {
			validateBean(bean);
		} catch (SecurityException e) {
			logger.error("SecurityException" + e);
		} catch (NoSuchFieldException e) {
			logger.error("NoSuchFieldException" + e);
		} catch (InstantiationException e) {
			logger.error("InstantiationException" + e);
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException" + e);
		}
	}

	public static void validateBean(Object obj) throws NoSuchFieldException,
			SecurityException, InstantiationException, IllegalAccessException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldname = field.getName();
			Object fieldValue = field.get(obj);
			Validator val = field.getAnnotation(Validator.class);
			List<String> allowedValues = new ArrayList<String>();
			if (null != val && val.validate()) {
				for (String str : val.allowedValues()) {
					allowedValues.add(str);
				}
				//Null check
				if (val.nullcheck() && isNull(fieldValue)) {
					throw new IllegalArgumentException("Field " + fieldname + " Cannot be null");
				}
				//if field is blank then no need to check any other validation
				if(!isBlank(""+fieldValue)){
					//Allowed Values Check
					boolean isAllowedValuesAvailable = allowedValues.size()>1 ? true : !isBlank(allowedValues.get(0)) ? true : false;
					if (isAllowedValuesAvailable && !allowedValues.contains(fieldValue.toString())) {
						throw new IllegalArgumentException("Field " + fieldname + " val is " + fieldValue + " allowed value is " + allowedValues);
					}
					logger.debug("FieldName {} : FieldValue {}", fieldname, fieldValue);
					//Range Check
					if(val.maxVal() != Long.MAX_VALUE || val.minVal()!=Long.MIN_VALUE)
					{
						Integer intFieldVal = null;
						try{
							intFieldVal = Integer.parseInt(fieldValue.toString().trim());
						}catch(NumberFormatException e){
							throw new IllegalArgumentException("Field "+fieldname +" is not in correct format, should be integer." );
						}
						if (intFieldVal > val.maxVal() || intFieldVal < val.minVal()) {
							throw new IllegalArgumentException("Field " + fieldname + " not in range, correct range is: [" + val.minVal() + "," + val.maxVal() + "]");
						}
					}
					//length check
					if(val.maxLength() != Integer.MAX_VALUE || val.minVal()!=Integer.MIN_VALUE)
					{
						int valueLength = (""+fieldValue).length();
						if (valueLength > val.maxLength() || valueLength < val.minLength()) {
							throw new IllegalArgumentException("Field " + fieldname + " length is invalid, correct lenght should be within : [" + val.minLength() + "," + val.maxLength() + "]");
						}
					}
					//Regexe validation
					if(!isBlank(val.regex())){
						Pattern pattern = Pattern.compile(val.regex());
						Matcher matcher = pattern.matcher(String.valueOf(fieldValue));
						if(!matcher.find()){
							throw new IllegalArgumentException("Fieldname "+fieldname +" does not match the pre-defined pattern");
						}
					}
				}
			}
		}
		logger.debug("validation Succeeded");
	}

	private static boolean isNull(Object obj) {
		boolean isnull = false;
		if (obj == null) {
			isnull = true;
		} else if ((obj instanceof String)
				&& String.valueOf(obj).trim().length() < 1) {
			isnull = true;
		}
		return isnull;
	}

	public static boolean isBlank(final CharSequence charSeq) {
		int strLen;
		if (charSeq == null || (strLen = charSeq.length()) == 0 || charSeq.equals("null")) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(charSeq.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
