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

    public SinhVien(){}
    
    public String getMssv(){
        return this.mssv;
    }
    
    public String getHo(){
        return this.ho;
    }
    
    public String getTen(){
        return this.ten;
    }
    
    public String getLop(){
        return this.lop;
    }
    
    public Date getNgaySinh(){
        return this.ngaySinh;
    }
    
    public int getGioiTinh(){
        return this.gioiTinh;
    }
    
    public String getDiaChi(){
        return this.diaChi;
    }
    
    public String getEmail(){
        return this.email;
    }

    public boolean getDaTotNghiep(){
        return this.daTotNghiep;
    }

    public void setMssv(String mssv){
        this.mssv=mssv;
    }

    public void setHo(String ho){
        this.ho=ho;
    }

    public void setTen(String ten){
        this.ten=ten;
    }

    public void setLop(String lop){
        this.lop=lop;
    }

    public void setNgaySinh(Date ngaySinh){
        this.ngaySinh=ngaySinh;
    }

    public void setGioiTinh(int gioiTinh){
        this.gioiTinh=gioiTinh;
    }

    public void setDiaChi(String diaChi){
        this.diaChi=diaChi;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setDaTotNghiep(boolean daTotNghiep) {
         this.daTotNghiep=daTotNghiep;
    }

    public SinhVien(String mssv, String hoTen, String lop, Date ngaySinh, int gioiTinh, String diaChi, String email, boolean daTotNghiep){
        this.mssv=mssv;
        this.ho=ho;
        this.ten=ten;
        this.lop=lop;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
        this.diaChi=diaChi;
        this.email=email;
        this.daTotNghiep=daTotNghiep;
    }
}
