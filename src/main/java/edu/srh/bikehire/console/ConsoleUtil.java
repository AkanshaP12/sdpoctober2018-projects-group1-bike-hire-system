package edu.srh.bikehire.console;

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
}
