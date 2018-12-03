package vn.edu.itdlu.a1610207.quanlythongtinsinhvien;

import java.util.Date;

public class SinhVien {
    String mssv;
    String ho;
    String ten;
    String lop;
    Date ngaySinh;
    int gioiTinh;
    String diaChi;
    String email;
    boolean daTotNghiep;

    public SinhVien() {
    }

    public SinhVien(String mssv, String hoTen, String lop, Date ngaySinh, int gioiTinh, String diaChi, String email, boolean daTotNghiep) {
        this.mssv = mssv;
        this.ho = ho;
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.daTotNghiep = daTotNghiep;
    }

    public String getMssv() {
        return this.mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHo() {
        return this.ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return this.lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getDaTotNghiep() {
        return this.daTotNghiep;
    }

    public void setDaTotNghiep(boolean daTotNghiep) {
        this.daTotNghiep = daTotNghiep;
    }
}
