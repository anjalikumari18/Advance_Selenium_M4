package Programs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calendar_date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Date date=new Date();   //used to get current date and time
		    System.out.println(date);
		    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");  //used to format the date
		    String currentdate=sdf.format(date);
		    System.out.println(currentdate);
			
			//capture the current system date 5 days after
	        Calendar cal =sdf.getCalendar();   //Calendar is used to manipulate date values 
		    cal.add(Calendar.DAY_OF_MONTH,15); 
	        String expectedDate1 = sdf.format(cal.getTime());
	        System.out.println(expectedDate1);
		
		
		
	}

}
