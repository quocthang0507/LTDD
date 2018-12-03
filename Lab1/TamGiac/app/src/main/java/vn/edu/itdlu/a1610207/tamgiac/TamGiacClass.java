package vn.edu.itdlu.a1610207.tamgiac;

public class TamGiacClass {
    int canhA;
    int canhB;
    int canhC;

    public TamGiacClass() {
        this.canhA = this.canhB = this.canhC = 0;
    }

    public void SetCanh() {
        this.canhA = 5;
        this.canhB = 10;
        this.canhC = 12;
    }

    public void SetCanh(int a, int b, int c) {
        this.canhA = a;
        this.canhB = b;
        this.canhC = c;
    }

    public int getCanhA() {
        return this.canhA;
    }

    public int getCanhB() {
        return this.canhB;
    }

    public int getCanhC() {
        return this.canhC;
    }

    public boolean KiemTraTamGiac() {
        return (this.canhA + this.canhB >= this.canhC) && (this.canhB + this.canhC >= this.canhA) &&
                (this.canhC + this.canhA >= this.canhB);
    }

    public double TinhChuViTamGiac() {
        return this.canhA + this.canhB + this.canhC;
    }

    public double TinhDienTichTamGiac() {
        double p = TinhChuViTamGiac() / 2;
        return Math.sqrt(p * (p - this.canhA) * (p - this.canhB) * (p - this.canhC));
    }

    public boolean KiemTraTamGiacVuong(int a, int b, int c) {
        if (a * a + b * b == c * c || b * b + c * c == a * a || c * c + a * a == b * b)
            return true;
        return false;
    }

    public int PhanLoaiTamGiac() {
        if (KiemTraTamGiac() == false)
            return 0;
        else if (this.canhA == this.canhB && this.canhB == this.canhC)
            return 1;
        else if (((this.canhA == this.canhB) ||
                (this.canhB == this.canhC) ||
                (this.canhA == this.canhC)) &&
                KiemTraTamGiacVuong(this.canhA, this.canhB, this.canhC) == true)
            return 2;
        else if ((this.canhA == this.canhB) ||
                (this.canhB == this.canhC) ||
                (this.canhA == this.canhC))
            return 3;
        else if (KiemTraTamGiacVuong(this.canhA, this.canhB, this.canhC) == true)
            return 4;
        else return 5;
    }

    public String KetQuaPhanLoai() {
        int kq = PhanLoaiTamGiac();
        if (kq == 0) return "Đây không phải là tam giác";
        else if (kq == 1) return "Đây là tam giác đều";
        else if (kq == 2) return "Đây là tam giác cân vuông";
        else if (kq == 3) return "Đây là tam giác cân";
        else if (kq == 4) return "Đây là tam giác vuông";
        else return "Đây là tam giác thường";
    }
}
