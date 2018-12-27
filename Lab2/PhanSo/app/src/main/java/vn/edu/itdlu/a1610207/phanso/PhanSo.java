package vn.edu.itdlu.a1610207.phanso;

public class PhanSo {
	private int tuSo;
	private int mauSo;
	
	public PhanSo() {
		this.tuSo = this.mauSo = 1;
	}
	
	public PhanSo(int tuSo, int mauSo) {
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}
	
	public double tinhGiaTriPhanSo() {
		if (this.mauSo != 0)
			return this.tuSo / this.mauSo;
		else return Double.POSITIVE_INFINITY;
	}
	
	@Override
	public String toString(){
		return xuatPhanSo();
	}
	
	public String xuatPhanSo() {
		return this.tuSo + "/" + this.mauSo;
	}
	
	int timUCLN(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	int BCNN(int a, int b) {
		return (a * b) / timUCLN(a, b);
	}
	
	public void rutGonPhanSo() {
		int ucln = this.timUCLN(this.tuSo, this.mauSo);
		this.tuSo /= ucln;
		this.mauSo /= ucln;
	}
	
	public PhanSo congPhanSo(PhanSo b) {
		PhanSo tong = new PhanSo(this.tuSo * b.mauSo + b.tuSo * this.mauSo, this.mauSo * b.mauSo);
		tong.rutGonPhanSo();
		return tong;
	}
	
	public PhanSo truPhanSo(PhanSo b) {
		PhanSo hieu = new PhanSo(this.tuSo * b.mauSo - b.tuSo * this.mauSo, this.mauSo * b.mauSo);
		hieu.rutGonPhanSo();
		return hieu;
	}
	
	public PhanSo nhanPhanSo(PhanSo b) {
		PhanSo tich = new PhanSo(this.tuSo * b.tuSo, b.mauSo * this.mauSo);
		tich.rutGonPhanSo();
		return tich;
	}
	
	public PhanSo chiaPhanSo(PhanSo b) {
		if (b.tuSo * this.mauSo != 0) {
			PhanSo thuong = new PhanSo(this.tuSo * b.mauSo, b.tuSo * this.mauSo);
			thuong.rutGonPhanSo();
			return thuong;
		} else return null;
	}
}
