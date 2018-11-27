package edu.srh.bikehire.booking.impl;

import edu.srh.bikehire.booking.Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//MyGETRequest
public class DisplayCatalogue implements Booking {
	public static void main(String args[]) throws IOException {
	    URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/1/comments");
	    String readLine = null;
	    HttpURLConnection conn = (HttpURLConnection) urlForGetRequest.openConnection();
	    conn.setRequestMethod("GET");
	    
	    int responseCode = conn.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conn.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        
	        System.out.println("JSON String Result " + response.toString());
	        
	    } else {
	        System.out.println("Error!");
	    }
	}

	
}
