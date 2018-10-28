package vn.edu.itdlu.a1610207.calculator;

import android.app.DialogFragment;
import android.content.Context;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        addEventListener();
        setToolbar();
    }

    void map() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
    }

    void addEventListener() {
        navigationView.setNavigationItemSelectedListener(this);
        //...
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
        // For example, swap UI fragments here
        switch (menuItem.getItemId()) {
            //Calculator mode
            case R.id.cal_standard:
                setToast("Standard nè, ahihi!!!", Toast.LENGTH_SHORT);
                break;
            case R.id.cal_scientific:
                setToast("Scientific nè, ahihi!!!", Toast.LENGTH_SHORT);
                break;
            case R.id.cal_programmer:
                setToast("Programmer nè, ahihi!!!", Toast.LENGTH_SHORT);
                break;
            case R.id.cal_date:
                setToast("Date Calculation nè, ahihi!!!", Toast.LENGTH_SHORT);
                break;

            //Converter mode
            case R.id.con_currency:
                break;
            case R.id.con_volume:
                break;
            case R.id.con_length:
                break;
            case R.id.con_weight:
                break;
            case R.id.con_temperature:
                break;
            case R.id.con_energy:
                break;
            case R.id.con_area:
                break;
            case R.id.con_speed:
                break;
            case R.id.con_time:
                break;
            case R.id.con_power:
                break;
            case R.id.con_data:
                break;
            case R.id.con_pressure:
                break;
            case R.id.con_angle:
                break;
            case R.id.about:
                DialogFragment dialogFragment = new myDialogFragment();
                dialogFragment.show(getFragmentManager(), "about");
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * Set the toolbar as the action bar and add nav drawer button
     */
    void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
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
