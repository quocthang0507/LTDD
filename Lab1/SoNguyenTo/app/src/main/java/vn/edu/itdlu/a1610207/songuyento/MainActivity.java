package vn.edu.itdlu.a1610207.songuyento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNhap = (Button) findViewById(R.id.btnNhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoNguyenTo n=new SoNguyenTo();
                n.setValue(GetValueFromEditText(findViewById(R.id.tbxNhap)));
                if(n.KiemTraSoNguyenDuong())
                {
                    String s = "";
                    s+="Đây là số nguyên dương";
                    if(n.KiemTraSoNguyenTo(n.getValue()))
                        s+="\nVà cũng là số nguyên tố!";
                    else s+="\nNhưng không phải là số nguyên tố!";
                    s+="\nCác số nguyên tố nhỏ hơn n là : \n";
                    List<Integer> ds1=n.XuatSoNguyenToNhoHon();
                    s+=((List) ds1).toString();
                    s+=("\nKết quả phân tích các số ra thừa số nguyên tố : \n");
                    List<Integer> ds2=n.PhanTichRaSoNguyenTo();
                    s+=((List) ds2).toString();
                    SetTextForTextView(s);
                }
                else SetTextForTextView("Đây không phải là số nguyên dương!");
            }
        });
    }

    private void PrintObject(Object obj) {
        String str = String.valueOf(obj);
        Log.d("Thang", str);
    }

    int GetValueFromEditText(View v){
        EditText t = (EditText)v;
        return Integer.parseInt(t.getText().toString());
    }

    void SetTextForTextView(String s){
        TextView t = (TextView) findViewById(R.id.tvKQ);
        t.setText(s);
    }
}
