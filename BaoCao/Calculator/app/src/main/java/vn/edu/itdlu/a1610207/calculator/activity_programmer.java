package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class activity_programmer extends AppCompatActivity implements View.OnClickListener {

    ArrayList<View> allButtons;
    ActionProcess action = new ActionProcess();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    void findAllButtons() {
        allButtons = new ArrayList<>();
        allButtons = ((LinearLayout) findViewById(R.id.layout_programmer)).getTouchables();
    }

    void addOnClickListener() {
        Button button;
        ImageButton imageButton;
        for (View view : allButtons)
            if (view instanceof Button) {
                button = (Button) view;
                button.setOnClickListener(this);
            } else if (view instanceof ImageButton) {
                imageButton = (ImageButton) view;
                imageButton.setOnClickListener(this);
            }
    }

    @Override
    public void onClick(View v) {
        String name = v.getResources().getResourceName(v.getId());
        action.actionPerformed((MathView) findViewById(R.id.formula_1), (TextView) findViewById(R.id.formula_2), (TextView) findViewById(R.id.result), name.split("/")[1], false);
    }
}
