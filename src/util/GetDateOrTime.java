package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GetDateOrTime {
	
	// Generate current date 
	public Date generateDate() throws ParseException {
		// Generate current date 
		Date newDate = new Date();
		// Format the new date
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(newDate);
		Date result = formatter.parse(date);
		// Console trail
		System.out.println("GetDateOrTime generated: "+result); //prints out current Date
				
		return result;
	}
	public LocalDateTime generateLocalDatetime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
		String nowTime = localDateTime.format(formatter);
		System.out.println(nowTime);
		return localDateTime;
	}
	// Generate current local date
	public LocalDate generateLocalDate() {
		// Generate current local date based on system clock
		LocalDate generatedLocalDate = LocalDate.now();
		// Format the new local date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Console trail
		System.out.println("GetDateOrTime generated: "+dateFormat.format(generatedLocalDate)); //prints out current Date
		return generatedLocalDate;
	}
	
	// Take the passed LocalDate and convert it to Date, return Date type
	public Date convertLocalDateToDate(LocalDate thisLocalDate) {
		Date convertedDate = Date.from(thisLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// Console trail
		System.out.println("Local Date (type) converted to Date (type)");
		System.out.println("Result: " + convertedDate);
		return convertedDate;
	}
	
	// Take the passed date and convert it to LocalDate, return LocalDate type
	public LocalDate convertDateToLocalDate(Date thisDate) {
		LocalDate convertedLocalDate = thisDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// Console trail
		System.out.println("Date (type) converted to Local Date (type)");
		System.out.println("Result: " + convertedLocalDate);
		return convertedLocalDate;
	}
}
