package vn.edu.itdlu.a1610207.calculator;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    android.support.v7.widget.Toolbar toolbar;
    ActionBar actionBar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        map();
        addEventListener();
        setToolbar();
    }

    void map() {
        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
    }

    void addEventListener() {
        navigationView.setNavigationItemSelectedListener(this);
        //...
    }

    /**
     * Set the toolbar as the action bar and add nav drawer button
     */
    void setToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    /**
     * Handle navigation click events
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // close drawer when item is tapped
        drawerLayout.closeDrawers();
        // remove the content of framelayout before it is used
        // For example, swap UI fragments here
        switch (menuItem.getItemId()) {
            //Calculator mode
            case R.id.cal_standard:
                setToast("Standard Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_standard.class);
                startActivity(intent);
                break;
            case R.id.cal_scientific:
                setToast("Scientific Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_scientific.class);
                startActivity(intent);
                break;
            case R.id.cal_programmer:
                setToast("Programmer Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_programmer.class);
                startActivity(intent);
                break;
            case R.id.cal_date:
                setToast("Date Calculation Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_date.class);
                startActivity(intent);
                break;

            //Converter mode
            case R.id.con_currency:
                setToast("Currency Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_currency.class);
                startActivity(intent);
                break;
            case R.id.con_volume:
                setToast("Volume Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_volume.class);
                startActivity(intent);
            break;
            case R.id.con_length:
                setToast("Length Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_length.class);
                startActivity(intent);
                break;
            case R.id.con_weight:
                setToast("Weight and Mass Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_weight.class);
                startActivity(intent);
                break;
            case R.id.con_temperature:
                setToast("Temperature Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_temperature.class);
                startActivity(intent);
                break;
            case R.id.con_energy:
                setToast("Energy Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_energy.class);
                startActivity(intent);
                break;
            case R.id.con_area:
                setToast("Area Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_area.class);
                startActivity(intent);
                break;
            case R.id.con_speed:
                setToast("Speed Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_speed.class);
                startActivity(intent);
                break;
            case R.id.con_time:
                setToast("Time Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_time.class);
                startActivity(intent);
                break;
            case R.id.con_power:
                setToast("Power Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_power.class);
                startActivity(intent);
                break;
            case R.id.con_data:
                setToast("Data Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_data.class);
                startActivity(intent);
                break;
            case R.id.con_pressure:
                setToast("Pressure Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_pressure.class);
                startActivity(intent);
                break;
            case R.id.con_angle:
                setToast("Angle Converter Mode", Toast.LENGTH_SHORT);
                intent = new Intent(MainActivity.this, activity_angle.class);
                startActivity(intent);
                break;
            case R.id.about:
                DialogFragment dialogFragment = new myDialogFragment();
                dialogFragment.show(getFragmentManager(), "about");
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Open the drawer when the button is tapped
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /**
     * Display the toast notification within the duration
     */
    void setToast(String string, int length) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, string, length);
        toast.show();
    }
}
