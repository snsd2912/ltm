/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

/**
 *
 * @author DELL
 */
public class Monhoc {
    private String maMH;
    private String tenMH;
    private String nhomMH;
    private String soTC;
    private String maLop;
    private String thu;
    private int tietbd;
    private int sotiet;
    private String phong;
    private String tuan;

    public Monhoc() {
    }

    public Monhoc(String maMH, String tenMH, String nhomMH, String soTC, String maLop, String thu, int tietbd, int sotiet, String phong, String tuan) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.nhomMH = nhomMH;
        this.soTC = soTC;
        this.maLop = maLop;
        this.thu = thu;
        this.tietbd = tietbd;
        this.sotiet = sotiet;
        this.phong = phong;
        this.tuan = tuan;
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

    public int getTietbd() {
        return tietbd;
    }

    public void setTietbd(int tietbd) {
        this.tietbd = tietbd;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setSotiet(int sotiet) {
        this.sotiet = sotiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTuan() {
        return tuan;
    }

    public void setTuan(String tuan) {
        this.tuan = tuan;
    }

    
    
    
    
    @Override
    public String toString(){
        return this.maMH+" "+this.tenMH+" "+this.maLop+" "+this.nhomMH+" "+this.phong+" \n STC:"+this.soTC
                +" "+ this.tietbd + "-" + this.sotiet + " \n Tuan: "+ this.tuan;
    }
    
}
