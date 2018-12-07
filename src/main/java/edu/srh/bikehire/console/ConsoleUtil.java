package edu.srh.bikehire.console;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleUtil {
	public static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
	public static String getStringForDate(Calendar calendar)
	{
		SimpleDateFormat format = new SimpleDateFormat();
		return format.format(calendar.getTime());
	}
}
