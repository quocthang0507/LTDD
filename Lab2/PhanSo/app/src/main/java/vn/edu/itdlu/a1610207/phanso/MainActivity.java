package vn.edu.itdlu.a1610207.phanso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvHienThi;
    private Button btRun, btXoa;
    private Button btCong, btTru, btNhan, btChia;
    private EditText etTuSoA, etMauSoA, etTuSoB, etMauSoB;
    private int tuSoA, tuSoB, mauSoA, mauSoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Map();
    }

    void Map() {
        tvHienThi = (TextView) findViewById(R.id.tvKetQua);
        btRun = (Button) findViewById(R.id.btnRun);
        btXoa = (Button) findViewById(R.id.btnXoa);
        btCong = (Button) findViewById(R.id.btnCong);
        btTru = (Button) findViewById(R.id.btnTru);
        btNhan = (Button) findViewById(R.id.btnNhan);
        btChia = (Button) findViewById(R.id.btnChia);
        etTuSoA = (EditText) findViewById(R.id.etTuSoA);
        etTuSoB = (EditText) findViewById(R.id.etTuSoB);
        etMauSoA = (EditText) findViewById(R.id.etMauSoA);
        etMauSoB = (EditText) findViewById(R.id.etMauSoB);
    }

    boolean layDuLieu() {
        try {
            tuSoA = Integer.parseInt(this.etTuSoA.getText().toString());
            mauSoA = Integer.parseInt(this.etMauSoA.getText().toString());
            tuSoB = Integer.parseInt(this.etTuSoB.getText().toString());
            mauSoB = Integer.parseInt(this.etMauSoB.getText().toString());
            if (mauSoA == 0 || mauSoB == 0) throw new Exception();
        } catch (Exception e) {
            tvHienThi.setText("Nhập sai!!!");
            return false;
        }
        return true;
    }

    public void btXoa_onClick(View v) {
        etMauSoA.setText("");
        etTuSoA.setText("");
        etTuSoB.setText("");
        etMauSoB.setText("");
        tvHienThi.setText("");
    }

    public void btRun_onClick(View v) {
        if (layDuLieu()) {
            PhanSo phanSoA = new PhanSo(tuSoA, mauSoA);
            PhanSo phanSoB = new PhanSo(tuSoB, mauSoB);
            phanSoA.rutGonPhanSo();
            phanSoB.rutGonPhanSo();
            etTuSoA.setText("" + phanSoA.tuSo);
            etMauSoA.setText("" + phanSoA.mauSo);
            etTuSoB.setText("" + phanSoB.tuSo);
            etMauSoB.setText("" + phanSoB.mauSo);
            tvHienThi.setText("Đã rút gọn 2 phân số");
        }
    }

    public void btCong_onClick(View v) {
        if (layDuLieu()) {
            PhanSo kq = new PhanSo(tuSoA, mauSoA);
            kq = kq.congPhanSo(new PhanSo(tuSoB, mauSoB));
            tvHienThi.setText("Kết quả phép cộng 2 phân số trên là : " + kq.xuatPhanSo());
        }
    }

    public void btTru_onClick(View v) {
        if (layDuLieu()) {
            PhanSo kq = new PhanSo(tuSoA, mauSoA);
            kq = kq.truPhanSo(new PhanSo(tuSoB, mauSoB));
            tvHienThi.setText("Kết quả phép trừ 2 phân số trên là : " + kq.xuatPhanSo());
        }
    }

    public void btNhan_onClick(View v) {
        if (layDuLieu()) {
            PhanSo kq = new PhanSo(tuSoA, mauSoA);
            kq = kq.nhanPhanSo(new PhanSo(tuSoB, mauSoB));
            tvHienThi.setText("Kết quả phép nhân 2 phân số trên là : " + kq.xuatPhanSo());
        }
    }

    public void btChia_onClick(View v) {
        if (layDuLieu()) {
            PhanSo kq = new PhanSo(tuSoA, mauSoA);
            kq = kq.chiaPhanSo(new PhanSo(tuSoB, mauSoB));
            tvHienThi.setText("Kết quả phép chia 2 phân số trên là : " + kq.xuatPhanSo());
        }
    }
}
