/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class main {
    
    public static void main(String[] args) throws Exception {
//        Scanner inScanner = new Scanner(System.in);
//        System.out.println("Enter username: ");
//        String username = inScanner.nextLine().trim();
//        System.out.println("Enter password: ");
//        String password = inScanner.nextLine().trim();

String username = "B17DCCN530";
String password = "56563000";
        
        String cookie = Cookie.getCookie();
        
        // to get first viewstate
        String request1 = Request.createWelcomePageRequest(cookie);
        Request.sendRequest(request1, "viewstate1.txt");
        String viewstate1 = Cookie.getViewState("viewstate1.txt");
        
        // to log in
        String request2 = Request.createLoginRequest(username, password, cookie, viewstate1);
        Request.sendRequest(request2, "viewstate2.txt");
        
//        // to get score page
//        String request3 = Request.createScorePageRequest(cookie);
//        Request.sendRequest(request3, "viewstate3.txt");
//        String viewstate3 = Cookie.getViewState("viewstate3.txt");
//        
//        // to get score list
//        String request4 = Request.createScoreRequest(cookie, viewstate3);
//        Request.sendRequest(request4, "viewstate4.txt");
//        Cookie.getScoreList("viewstate4.txt");
//        String viewstate4 = Cookie.getViewState("viewstate4.txt");
//        
        // to get time table page
        String request5 = Request.createTKBPageRequest(cookie);
        Request.sendRequest(request5, "viewstate5.txt");
        String viewstate5 = Cookie.getViewState("viewstate5.txt");
        
        // to get tkb
        String request6 = Request.createTKBRequest(cookie);
        Request.sendRequest(request6, "viewstate6.txt");
        String viewstate6 = Cookie.getViewState("viewstate6.txt");
        
        //System.out.println(viewstate6.charAt(viewstate6.length()-1));
        // to get tkb by week
        String year = "20201";
        String week = "Tuần 11 [Từ 16/11/2020 -- Đến 22/11/2020]";
        String request7 = Request.createTKBRequestByWeek(cookie, viewstate6, year, week);
        //System.out.println(request7);
        Request.sendRequest(request7, "viewstate7.txt");
        String request8 = Request.createRedirectRequest(cookie);
        Request.sendRequest(request8, "viewstate8.txt");
    }
}
