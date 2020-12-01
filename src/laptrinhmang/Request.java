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
import java.net.UnknownHostException;

/**
 *
 * @author DELL
 */
public class Request {
  
    public Request(){
    }
    
    public static String createWelcomePageRequest(String cookie){
        String request = "GET /default.aspx?page=gioithieu HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Cookie:" + cookie + "\r\n" +
                            "Connection: close \r\n\r\n";
        return request;
    }
    
    public static String createLoginRequest(String username, String password, String cookie, String viewstate){
        // send request to log in
        String body = "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" 
                            +"Content-Disposition: form-data; name=\"__EVENTTARGET\"\r\n" + "\r\n" + "\r\n" 
                            +"------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" 
                            +"Content-Disposition: form-data; name=\"__EVENTARGUMENT\"\r\n" + "\r\n" + "\r\n" 
                            +"------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n"
                            +"Content-Disposition: form-data; name=\"__VIEWSTATE\"\r\n" + "\r\n" 
                            + viewstate + "\r\n"
                            +"------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" 
                            +"Content-Disposition: form-data; name=\"__VIEWSTATEGENERATOR\"\r\n" + "\r\n" + "CA0B0334\r\n" 
                            +"------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" 
                            +"Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtTaiKhoa\"\r\n" +"\r\n" +
                            username+"\r\n" +
                            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                            "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$txtMatKhau\"\r\n" +
                            "\r\n" +
                            password+"\r\n" +
                            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                            "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ucDangNhap$btnDangNhap\"\r\n" +
                            "\r\n" +
                            "------WebKitFormBoundaryYItBKvbNa95NTsSB--\r\n";
            
        String request = "POST /default.aspx HTTP/1.1\r\n"
                            + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n"
                            + "Host: " + "qldt.ptit.edu.vn" + "\r\n" 
                            + "Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryYItBKvbNa95NTsSB\r\n"
                            + "Content-Length: " + body.length() + "\r\n"
                            + "Cookie: " + cookie + "\r\n"
                            + "Connection: close \r\n"
                            + "\r\n"
                            + body ;
        return request;
    }
    
    public static String createScorePageRequest(String cookie){
        String request = "GET /Default.aspx?page=xemdiemthi HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Cookie:"+ cookie +"\r\n" +
                            "Connection: close\r\n\r\n";
        return request;
    }
    
    public static String createScoreRequest(String cookie, String viewstate){
        String body = 
            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "Content-Disposition: form-data; name=\"__EVENTTARGET\"\r\n" +
            "\r\n" +
            "ctl00$ContentPlaceHolder1$ctl00$lnkChangeview2\r\n" +
            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "Content-Disposition: form-data; name=\"__EVENTARGUMENT\"\r\n" +
            "\r\n" +
            "\r\n" +
            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "Content-Disposition: form-data; name=\"__VIEWSTATE\"\r\n" +
            "\r\n" +
            viewstate + "\r\n" +
            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "Content-Disposition: form-data; name=\"__VIEWSTATEGENERATOR\"\r\n" +
            "\r\n" +
            "CA0B0334\r\n" +
            "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$txtChonHK\"\r\n" +
            "\r\n" +
            "\r\n" +
            "------WebKitFormBoundaryYItBKvbNa95NTsSB--\r\n";
        String request = 
            "POST /Default.aspx?page=xemdiemthi HTTP/1.1\r\n" +
            "Host: qldt.ptit.edu.vn\r\n" +
            "Content-Length:"+body.length()+"\r\n" +
            "Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
            "Referer: http://qldt.ptit.edu.vn/Default.aspx?page=xemdiemthi\r\n" +
            "Accept-Encoding: gzip, deflate\r\n" +
            "Accept-Language: en-US,en;q=0.9\r\n" +
            "Cookie:"+cookie+"\r\n" +
            "Connection: close\r\n\r\n"
            + body;

        return request;
    }
    
    public static String createTKBRequestByWeek(String cookie, String viewstate, String year, String week){
        String body =   "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"__EVENTTARGET\"\r\n" +
                        "\r\n" +
                        "ctl00$ContentPlaceHolder1$ctl00$ddlTuan\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"__EVENTARGUMENT\"\r\n" +
                        "\r\n" +
                        "\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"__LASTFOCUS\"\r\n" +
                        "\r\n" +
                        "\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"__VIEWSTATE\"\r\n" +
                        "\r\n" +
                        viewstate + "\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"__VIEWSTATEGENERATOR\"\r\n" +
                        "\r\n" +
                        "CA0B0334\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ddlChonNHHK\"\r\n" +
                        "\r\n" +
                        year + "\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ddlLoai\"\r\n" +
                        "\r\n" +
                        "0\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                        "Content-Disposition: form-data; name=\"ctl00$ContentPlaceHolder1$ctl00$ddlTuan\"\r\n" +
                        "\r\n" +
                        week + "\r\n" +
                        "------WebKitFormBoundaryYItBKvbNa95NTsSB--\r\n";
        
        String request = "POST /default.aspx?page=thoikhoabieu&sta=0 HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "Content-Length:"+ body.length() +"\r\n" +
                            "Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryYItBKvbNa95NTsSB\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Cookie: "+ cookie +"\r\n" +
                            "Connection: close\r\n\r\n"+
                            body;    
        return request;
    }
    
    public static String createRedirectRequest(String cookie){
        String request = "GET /default.aspx?page=thoikhoabieu&sta=0 HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Referer: http://qldt.ptit.edu.vn/default.aspx?page=thoikhoabieu&sta=0\r\n" +
                            "Cookie: "+ cookie +"\r\n" +
                            "Connection: close\r\n\r\n";
        return request;
    }
    
    public static String createTKBPageRequest(String cookie){
        String request = "GET /Default.aspx?page=thoikhoabieu HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Referer: http://qldt.ptit.edu.vn/Default.aspx?page=thoikhoabieu\r\n" +
                            "Cookie: "+ cookie +"\r\n" +
                            "Connection: close\r\n\r\n";
        return request;
    }
    
    public static String createTKBRequest(String cookie){
        String request = "GET /default.aspx?page=thoikhoabieu&sta=1 HTTP/1.1\r\n" +
                            "Host: qldt.ptit.edu.vn\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                            "Referer: http://qldt.ptit.edu.vn/default.aspx?page=thoikhoabieu&sta=0\r\n" +
                            "Cookie: "+ cookie +"\r\n" +
                            "Connection: close\r\n\r\n";
        return request;
    }
    
    public static void sendRequest(String request, String filename) throws IOException{
        Socket s = new Socket(InetAddress.getByName("qldt.ptit.edu.vn"), 80);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);  
        out.println(request);
        
        // write response to file
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));     
        FileWriter file = new FileWriter(new File(filename));
        String inputLine="";
        while ((inputLine = in.readLine()) != null) file.write(inputLine+"\n");             
        file.close();
        in.close();
        s.close();
    }
    
//        GET /Default.aspx?page=thoikhoabieu HTTP/1.1
//        Host: qldt.ptit.edu.vn
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//        Referer: http://qldt.ptit.edu.vn/Default.aspx?page=thoikhoabieu
//        Accept-Encoding: gzip, deflate
//        Accept-Language: en-US,en;q=0.9
//        Cookie: ASP.NET_SessionId=mtohj445zmdgmb2pz5tnn1m0
//        If-Modified-Since: Sat, 14 Nov 2020 03:57:59 GMT
//        Connection: close


//        GET /default.aspx?page=thoikhoabieu&sta=1 HTTP/1.1
//        Host: qldt.ptit.edu.vn
//        Cache-Control: max-age=0
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//        Referer: http://qldt.ptit.edu.vn/default.aspx?page=thoikhoabieu&sta=0
//        Accept-Encoding: gzip, deflate
//        Accept-Language: en-US,en;q=0.9
//        Cookie: ASP.NET_SessionId=mtohj445zmdgmb2pz5tnn1m0
//        Connection: close
}
