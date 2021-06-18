import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 
 */

/**
 * @author Humberto
 *
 */
public class MainApp {

	private static final String rfc2822Pattern = "EEE, dd MMM yyyy HH:mm:ss Z";
	
	private static SimpleDateFormat format = new SimpleDateFormat(rfc2822Pattern, Locale.ENGLISH);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String time1 = "Thu, 21 Dec 2000 16:01:07 +0200";
		String time2 = "Mon, 15 May 2015 12:45:05 -0900";
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println("The amount of minutes between these timestamps is: "+
				calculateTimeBetweenTimestamps(convertRfcTimeToStandardTimeZoneDate(time1), 
												convertRfcTimeToStandardTimeZoneDate(time2)));
	}
	
	private static long calculateTimeBetweenTimestamps(Date time1, Date time2) {
		
		long time1seconds = Math.round(time1.getTime() / 1000);
		long time2seconds = Math.round(time2.getTime() / 1000);
		
		long intervalSeconds = time2seconds - time1seconds;
		
		double intervalMinutes = intervalSeconds / 60;
		
		return (long)intervalMinutes;
	}
	
	private static Date convertRfcTimeToStandardTimeZoneDate(String rfcTime) {
		
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		try {
			return format.parse(rfcTime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
