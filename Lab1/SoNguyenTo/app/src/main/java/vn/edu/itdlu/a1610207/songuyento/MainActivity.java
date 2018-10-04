package vn.edu.itdlu.a1610207.songuyento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoNguyenTo n=new SoNguyenTo();
        n.setValue(100);
        if(n.KiemTraSoNguyenDuong())
        {
            PrintObject("Day la so nguyen duong");
            if(n.KiemTraSoNguyenTo(n.getValue()))
                PrintObject("Day la so nguyen to");
            else PrintObject("Day khong phai la so nguyen to");
            PrintObject("Cac so nguyen to nho hon n");
            List<Integer> ds1=n.XuatSoNguyenToNhoHon();
            PrintObject(((List) ds1).toString());
            PrintObject("Phan tich cac so ra thua so nguyen to");
            List<Integer> ds2=n.PhanTichRaSoNguyenTo();
            PrintObject(((List) ds2).toString());
        }
        else PrintObject("Day khong phai la so nguyen duong");
    }

    private void PrintObject(Object obj) {
        String str = String.valueOf(obj);
        Log.d("Thang", str);
    }

}
