package hkins.baseplatform.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
	public static boolean isEmpty(String str) {
		if(str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(String str) {
		return !StringUtil.isEmpty(str);
	}
	
	public static boolean isNumeric(String str) {
		return NumberUtils.isDigits(str);
	}
	
	public static int indexOf(String str, String searchTarget, boolean ignoreCase) {
		if(ignoreCase) {
			return StringUtils.indexOfIgnoreCase(str, searchTarget);
		}
		return str.indexOf(searchTarget);
	}
	
	public static int laseIndexOf(String str, String searchTarget, boolean ignoreCase) {
		if(ignoreCase) {
			return StringUtils.lastIndexOfIgnoreCase(str, searchTarget);
		}
		return str.lastIndexOf(searchTarget);
	}
}
