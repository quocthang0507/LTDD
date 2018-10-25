package vn.edu.itdlu.a1610207.phanso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHienThi;
    Button btRun, btXoa;
    Button btCong, btTru, btNhan, btChia;
    EditText etTuSoA, etMauSoA, etTuSoB, etMauSoB;

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

    public void btXoa_onClick(View v) {
        etMauSoA.setText("");
        etTuSoA.setText("");
        etTuSoB.setText("");
        etMauSoB.setText("");
        tvHienThi.setText("");
    }

    public void btRun_onClick(View v) {
        int tuSoA = Integer.parseInt(this.etTuSoA.getText().toString());
        int mauSoA = Integer.parseInt(this.etMauSoA.getText().toString());
        int tuSoB = Integer.parseInt(this.etTuSoB.getText().toString());
        int mauSoB = Integer.parseInt(this.etMauSoB.getText().toString());
        PhanSo phanSoA = new PhanSo(tuSoA, mauSoA);
        PhanSo phanSoB = new PhanSo(tuSoB, mauSoB);
        phanSoA.rutGonPhanSo();
        phanSoB.rutGonPhanSo();
        this.tvHienThi.setText("Phân số tối giản của phân số A : " + phanSoA.xuatPhanSo());
        this.tvHienThi.setText("Phân số tối giản của phân số B : " + phanSoB.xuatPhanSo());
    }

    public void btCong_onClick(View v) {
        int tuSo = Integer.parseInt(this.etTuSoA.getText().toString());
        int mauSo = Integer.parseInt(this.etMauSoA.getText().toString());
        PhanSo kq = new PhanSo(tuSo, mauSo);
        kq = kq.congPhanSo(new PhanSo(Integer.parseInt(this.etTuSoB.getText().toString()), Integer.parseInt(this.etMauSoB.getText().toString())));
        tvHienThi.setText("Kết quả phép cộng 2 phân số trên là : " + kq.xuatPhanSo());
    }

    public void btTru_onClick(View v) {
        int tuSo = Integer.parseInt(this.etTuSoA.getText().toString());
        int mauSo = Integer.parseInt(this.etMauSoA.getText().toString());
        PhanSo kq = new PhanSo(tuSo, mauSo);
        kq = kq.truPhanSo(new PhanSo(Integer.parseInt(this.etTuSoB.getText().toString()), Integer.parseInt(this.etMauSoB.getText().toString())));
        tvHienThi.setText("Kết quả phép trừ 2 phân số trên là : " + kq.xuatPhanSo());
    }

    public void btNhan_onClick(View v) {
        int tuSo = Integer.parseInt(this.etTuSoA.getText().toString());
        int mauSo = Integer.parseInt(this.etMauSoA.getText().toString());
        PhanSo kq = new PhanSo(tuSo, mauSo);
        kq = kq.nhanPhanSo(new PhanSo(Integer.parseInt(this.etTuSoB.getText().toString()), Integer.parseInt(this.etMauSoB.getText().toString())));
        tvHienThi.setText("Kết quả phép nhân 2 phân số trên là : " + kq.xuatPhanSo());
    }

    public void btChia_onClick(View v) {
        int tuSo = Integer.parseInt(this.etTuSoA.getText().toString());
        int mauSo = Integer.parseInt(this.etMauSoA.getText().toString());
        PhanSo kq = new PhanSo(tuSo, mauSo);
        kq = kq.chiaPhanSo(new PhanSo(Integer.parseInt(this.etTuSoB.getText().toString()), Integer.parseInt(this.etMauSoB.getText().toString())));
        if (kq != null)
            tvHienThi.setText("Kết quả phép chia 2 phân số trên là : " + kq.xuatPhanSo());
        else tvHienThi.setText("Không thể thực hiện phép chia cho 0");
    }
}
