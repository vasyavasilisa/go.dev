package framework.functions;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeFunctions {

	public static String getCurrentDate(String pattern) {
		return formatDate(new Date(), pattern);
	}

	public static String getTimestamp() {
		return getCurrentDate("yyyyMMddHHmmss");
	}

	public static String formatDate(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
}