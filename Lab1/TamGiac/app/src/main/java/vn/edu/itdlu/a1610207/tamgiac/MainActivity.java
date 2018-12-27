package vn.edu.itdlu.a1610207.tamgiac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnKT = (Button) findViewById(R.id.btnKiemTra);
		btnKT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int a = GetValueFromTextView(findViewById(R.id.canhA));
				int b = GetValueFromTextView(findViewById(R.id.canhB));
				int c = GetValueFromTextView(findViewById(R.id.canhC));
				TamGiacClass tg = new TamGiacClass(a, b, c);
				ChangeValueTextView(tg.KetQuaPhanLoai());
			}
		});
	}
	
	int GetValueFromTextView(View tv) {
		return Integer.parseInt(((EditText) tv).getText().toString());
	}
	
	void ChangeValueTextView(String s) {
		TextView t = (TextView) findViewById(R.id.tvKQ);
		t.setText(s);
	}
	
	private void PrintObject(Object obj) {
		String str = String.valueOf(obj);
		Log.d("TG", str);
	}
}
