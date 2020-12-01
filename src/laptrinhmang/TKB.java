/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class TKB {
    
    public static String getDate(int i, int j){
        String oldDate = "07/09/2020";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar c = Calendar.getInstance();
	try{
	   c.setTime(sdf.parse(oldDate));
	}catch(ParseException e){
		e.printStackTrace();
	}
	 
	c.add(Calendar.DAY_OF_MONTH, 7*i+j);
	String newDate = sdf.format(c.getTime()); 
        return newDate;
    }
    
    public static int ngayCalculate(String thu){
        switch (thu) {
            case "Hai":
                return 0;
            case "Ba":
                return 1;
            case "Tư":
                return 2;
            case "Năm":
                return 3;
            case "Sáu":
                return 4;
            case "Bảy":
                return 5;
            default:
                return 6;
        }
    }
    
    public static int tietCalculate(int tietbd){
        switch (tietbd) {
            case 1:
                return 7;
            case 3:
                return 9;
            case 5:
                return 12;
            case 7:
                return 14;
            case 9:
                return 16;
            default:
                return 18;
        }
    }
    
    public static ArrayList<Kiphoc> getSubTKB(ArrayList<Kiphoc> listkh, String ngaybd, String ngaykt) throws ParseException {
        ArrayList<Kiphoc> listsubkh = new ArrayList<>();
	Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaybd);
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(ngaykt);
        for(Kiphoc kh: listkh){
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(kh.getNgay());
            if((date.after(date1)&&date.before(date2))||date.equals(date1)||date.equals(date2)){
                listsubkh.add(kh);
            }
        }
        return listsubkh;
    }
    
    public static ArrayList<Kiphoc> getTKB() throws FileNotFoundException{
        File file = new File("timetable-full.txt");
        ArrayList<Monhoc> list = new ArrayList<>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String fields[] = line.split("#");
            
            int row = Math.round((fields.length-9)/6);
            int col = 0;
            
            try{
                int x = Integer.parseInt(fields[8]);
                col = 9;
            }catch(NumberFormatException e){
                col = 8;
            }
            
            for(int i=0; i<row; i++){
                Monhoc mh = new Monhoc();
                mh.setMaMH(fields[1]);
                mh.setTenMH(fields[2]);
                mh.setNhomMH(fields[3]);
                mh.setSoTC(fields[4]);
                mh.setMaLop(fields[5]);
                mh.setThu(fields[col+i]);
                mh.setTietbd(Integer.parseInt(fields[col+row+i]));
                mh.setSotiet(Integer.parseInt(fields[col+2*row+i]));
                mh.setTuan(fields[fields.length-1-row+i]);
                
                if(fields[fields.length-1-3*row+i].length()>5){
                    mh.setPhong(fields[fields.length-1-3*row+i]);
                }else mh.setPhong(" ");
                
                //System.out.println(mh.toString()+"\n");
                list.add(mh);
            }
        }
        myReader.close();
        
        
        ArrayList<Kiphoc> listkh = new ArrayList<>();
        for(Monhoc mh : list){
            for(int i=0; i<mh.getTuan().length(); i++){
                if(Character.compare(mh.getTuan().charAt(i),'-')!=0){
                    Kiphoc kh = new Kiphoc();
                    kh.setMaLop(mh.getMaLop());
                    kh.setMaMH(mh.getMaMH());
                    kh.setTenMH(mh.getTenMH());
                    kh.setNhomMH(mh.getNhomMH());
                    kh.setSoTC(mh.getSoTC());
                    kh.setPhong(mh.getPhong());
                    kh.setThu(mh.getThu());
                    
                    int tietbd = tietCalculate(mh.getTietbd());
                    int thu = ngayCalculate(mh.getThu());
                    kh.setGiobatdau(tietbd);
                    kh.setGioketthuc(tietbd+mh.getSotiet());
                    kh.setNgay(getDate(i,thu));
                    
                    listkh.add(kh);
                }
            }
        }
        
        Collections.sort(listkh);
        return listkh;
    }
    
}
