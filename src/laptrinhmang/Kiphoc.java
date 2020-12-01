/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Kiphoc implements Comparable<Kiphoc>{
    private String maMH;
    private String tenMH;
    private String nhomMH;
    private String soTC;
    private String maLop;
    private String thu;
    private int giobatdau;
    private int gioketthuc;
    private String phong;
    private String ngay;

    public Kiphoc() {
    }

    public Kiphoc(String maMH, String tenMH, String nhomMH, String soTC, String maLop, String thu, int giobatdau, int gioketthuc, String phong, String ngay) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.nhomMH = nhomMH;
        this.soTC = soTC;
        this.maLop = maLop;
        this.thu = thu;
        this.giobatdau = giobatdau;
        this.gioketthuc = gioketthuc;
        this.phong = phong;
        this.ngay = ngay;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getNhomMH() {
        return nhomMH;
    }

    public void setNhomMH(String nhomMH) {
        this.nhomMH = nhomMH;
    }

    public String getSoTC() {
        return soTC;
    }

    public void setSoTC(String soTC) {
        this.soTC = soTC;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public int getGiobatdau() {
        return giobatdau;
    }

    public void setGiobatdau(int giobatdau) {
        this.giobatdau = giobatdau;
    }

    public int getGioketthuc() {
        return gioketthuc;
    }

    public void setGioketthuc(int gioketthuc) {
        this.gioketthuc = gioketthuc;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    
    
    @Override
    public String toString(){
        return this.maMH+" "+this.tenMH+"\nMa Lop:"+this.maLop+" - Nhom MH: "+this.nhomMH+" "+this.phong+"\nSTC:"+this.soTC
                +"\nGio: "+ this.giobatdau+ "-" + this.gioketthuc + "\nNgay: "+ this.ngay;
    }

    @Override
    public int compareTo(Kiphoc o) {
        try {
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(o.getNgay());
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getNgay());
            if(date1.after(date2)) return 1;
            else if(date1.before(date2)) return -1;
            else {
                if(this.giobatdau > o.giobatdau) return 1;
                return -1;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Kiphoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
