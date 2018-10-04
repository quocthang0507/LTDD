package vn.edu.itdlu.a1610207.tamgiac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TamGiacClass tamGiac = new TamGiacClass();
        tamGiac.SetCanh(3, 4, 5);
        int phanLoai = tamGiac.PhanLoaiTamGiac();
        PrintObject(Integer.toString(phanLoai));
    }

    private void PrintObject(Object obj) {
        String str = String.valueOf(obj);
        Log.d("TG", str);
    }
}
