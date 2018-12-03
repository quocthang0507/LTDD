package vn.edu.itdlu.a1610207.songuyento;

import java.util.ArrayList;
import java.util.List;

public class SoNguyenTo {
    int so;

    public SoNguyenTo() {
        this.so = 0;
    }

    public int getValue() {
        return this.so;
    }

    public void setValue(int a) {
        this.so = a;
    }

    public boolean KiemTraSoNguyenTo(int n) {
        int t = (int) Math.sqrt(n);
        for (int i = 2; i <= t; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public boolean KiemTraSoNguyenDuong() {
        return this.so > 0;
    }

    public List<Integer> XuatSoNguyenToNhoHon() {
        List<Integer> kq = new ArrayList<Integer>();
        for (int i = 2; i <= this.so; i++)
            if (KiemTraSoNguyenTo(i))
                kq.add(i);
        return kq;
    }

    public List<Integer> PhanTichRaSoNguyenTo() {
        List<Integer> kq = new ArrayList<Integer>();
        int t = this.so;
        for (int i = 2; i <= this.so; i++)
            if (KiemTraSoNguyenTo(i)) {
                while (t % i == 0) {
                    t = t / i;
                    kq.add(i);
                }
                if (t == 1)
                    break;
            }
        return kq;
    }
}
