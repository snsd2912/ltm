/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Cookie {

    public Cookie() {
    }
    
    public static String getStatusCode() throws IOException {
        String statusCode="";
        File file = new File("viewstate.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if(line.contains("HTTP/1.1")){
                statusCode = line.split(" ")[1];            
                break;
            }
        }
        myReader.close();
        return statusCode;
    }
  
    public static String getCookie() throws IOException {
        try {
            URL url = new URL("http://qldt.ptit.edu.vn/");
            URLConnection conn = url.openConnection();
            String cookieValue = "";
            String fields = "";
            Map<String, List<String>> headerFields = conn.getHeaderFields();
            //System.out.println(headerFields);
            Set<String> headerFieldsSet = headerFields.keySet();
            Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
            //System.out.println(headerFieldsSet);
            while (hearerFieldsIter.hasNext()) {
                String headerFieldKey = hearerFieldsIter.next();
                //System.out.println(headerFieldKey);
                if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
                    List<String> headerFieldValue = headerFields.get(headerFieldKey);
                    //System.out.println(headerFieldValue);
                    for (String headerValue : headerFieldValue){
//                        System.out.println(headerValue+"\n");
                        fields = headerValue.split(";\\s*")[0];
                        //cookieValue = fields.split("=")[1];
                    }
                    break;
                }
            }          
            return fields;
        } catch (MalformedURLException ex) {
            //Logger.getLogger(getCookie.class.getName()).log(Level.SEVERE, null, ex);
        }	
        return "false";
    }
    
    public static String getViewState(String filename) throws IOException {
        File file = new File(filename);
        String cookie = "";
        String data = "";
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            if(line.contains("__VIEWSTATE")){
                String fields = line.split(" ")[4];
                cookie = fields.substring(7, fields.length()-1);             
                break;
            }
        }
        myReader.close();
        return cookie;
    }
    
    public static String getUsername(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader in = new BufferedReader(file);
        String inputLine = "";
        String username = "";
        while ((inputLine = in.readLine()) != null){
            if(inputLine.contains("id=\"ctl00_Header1_Logout1_lblNguoiDung\"")){
                String output = Cookie.splitHTML(inputLine);
                username = output.split("#")[1];
            }
        }
        in.close();
        return username;
    }
    
    public static void getScoreList(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader in = new BufferedReader(file);
        String inputLine="";
        BufferedWriter out = new BufferedWriter(new FileWriter("score.txt"));
        while ((inputLine = in.readLine()) != null){
            if(inputLine.contains("class=\"row-diem\"")){
                inputLine = Cookie.splitHTML(in.readLine());
                out.write(inputLine+"\n");
            }
        }
        in.close();
        out.close();
    }
    
    public static float getAverageScore(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader in = new BufferedReader(file);
        String inputLine="";
        float dtb = 0;
        BufferedWriter out = new BufferedWriter(new FileWriter("score.txt"));
        while ((inputLine = in.readLine()) != null){
            if(inputLine.contains("Điểm trung bình tích lũy")){
                String input = Cookie.splitHTML(inputLine);
                System.out.println(input);
                dtb = Float.parseFloat(input.split("#")[2].trim());
            }
        }
        in.close();
        out.close();
        return dtb;
    }
    
    public static void getTimeTable(String filename) throws IOException {
        FileReader file = new FileReader(filename);
        BufferedReader in = new BufferedReader(file);
        String inputLine="";
        BufferedWriter out = new BufferedWriter(new FileWriter("timetable-full.txt"));
        while ((inputLine = in.readLine()) != null){  
            //System.out.println(inputLine);
            if(inputLine.contains("<td width='60px' align='center'>")){
                //System.out.println("1");
                String input = "";
                input = input + inputLine;
                input = input + in.readLine();
                input = input + in.readLine();
                String output = Cookie.splitHTML(input);
                out.write(output+"\n");
            }
        }
        in.close();
        out.close();
    }
    
    public static String splitHTML(String input){
        String output = "";
        String content[] = input.split("[<>]");
        for (String retval: content) {
            if(retval.contains("td")
                    ||retval.contains("/tr")
                    ||retval.contains("/a")
                    ||retval.contains("div")
                    ||retval.contains("table")
                    ||retval.contains("style")
                    ||retval.contains("height")
                    ||retval.contains("align")
                    ||retval.contains("href")
                    ||retval.contains("span")||retval.equals("\n")||retval.equals(""))
                continue;
            
            retval = retval.trim();
            if(retval.equals("&nbsp;")){
                output = output + " #";
            }else{
                output = output + retval + "#";
            }
            
        }
//        String col[] = line.split(" ");
        //for(String s : line.split(" ")) output = output + s + " ";
        return output;
    }
}
