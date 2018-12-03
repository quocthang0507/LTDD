package vn.edu.itdlu.a1610207.quanlythongtinsinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DanhSachSinhVien {
    List<SinhVien> danhSach = new ArrayList<SinhVien>();

    public DanhSachSinhVien() {
    }

    public void setDanhSach(List<SinhVien> ds) {
        danhSach = ds;
    }

    public void ThemSV(SinhVien s) {
        this.danhSach.add(s);
    }

    public boolean XoaSV(SinhVien s) {
        return this.danhSach.remove(s);
    }

    public SinhVien TimSV(String mssv) {
        for (SinhVien s : this.danhSach) {
            if (s.getMssv() == mssv)
                return s;
        }
        return null;
    }

    public void SuaSV(String mssv, String ho, String ten, String lop, Date ngaySinh, int gioiTinh, String diaChi, String email, boolean daTotNghiep) {
        for (SinhVien s : this.danhSach)
            if (s.getMssv() == mssv) {
                s.setHo(ho);
                s.setTen(ten);
                s.setLop(lop);
                s.setNgaySinh(ngaySinh);
                s.setGioiTinh(gioiTinh);
                s.setDiaChi(diaChi);
                s.setEmail(email);
                s.setDaTotNghiep(daTotNghiep);
            }
    }

    public List<SinhVien> TimSinhVienDaTotNghiep() {
        List<SinhVien> kq = new ArrayList<SinhVien>();
        for (SinhVien s : this.danhSach)
            if (s.getDaTotNghiep())
                kq.add(s);
        return kq;
    }

    public List<SinhVien> TimSinhVienChuaTotNghiep() {
        List<SinhVien> kq = new ArrayList<SinhVien>();
        for (SinhVien s : this.danhSach)
            if (!s.getDaTotNghiep())
                kq.add(s);
        return kq;
    }

    public List<SinhVien> TimSinhVienTheoLop(String lop) {
        List<SinhVien> kq = new ArrayList<SinhVien>();
        for (SinhVien s : this.danhSach)
            if (s.getLop() == lop)
                kq.add(s);
        return kq;
    }

    public void SapXepTangTheoMSSV() {
        Collections.sort(danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sinhVien, SinhVien t1) {
                return sinhVien.getMssv().compareTo(t1.getMssv());
            }
        });
    }

    public void SapXepGiamTheoMSSV() {
        Collections.sort(danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sinhVien, SinhVien t1) {
                return t1.getMssv().compareTo(sinhVien.getMssv());
            }
        });
    }

    public void SapXepTangTheoTen() {
        Collections.sort(danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sinhVien, SinhVien t1) {
                return sinhVien.getTen().compareTo(t1.getTen());
            }
        });
    }

}
