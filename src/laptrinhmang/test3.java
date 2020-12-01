/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class test3 {
    public static void main(String[] args) throws IOException, ParseException {
//	String oldDate = "2020-09-07";
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	Calendar c = Calendar.getInstance();
//	try{
//	   c.setTime(sdf.parse(oldDate));
//	}catch(ParseException e){
//		e.printStackTrace();
//	}
//	 
//	c.add(Calendar.DAY_OF_MONTH, 7*9);
//	String newDate = sdf.format(c.getTime());  
//        
//	System.out.println("Date after Addition: "+newDate);
        long d = System.currentTimeMillis();
		Date date = new Date(d);
		System.out.println(date);
    }
}
