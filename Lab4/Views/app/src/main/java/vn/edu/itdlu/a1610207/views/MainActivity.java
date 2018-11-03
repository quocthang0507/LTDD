package vn.edu.itdlu.a1610207.views;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final String[] numbers = new String[]{
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
    final Context context = this;
    Button button;
    ProgressDialog progressDialog;
    int progressBarStatus = 0;
    Handler progressBarHandle = new Handler();
    long fileSize = 0;
    EditText editText;
    ImageView imageView;
    boolean flag = true;
    ImageButton imageButton;
    ListView listView;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_alertDialog) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.alertdialog, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_Alert();
        } else if (id == R.id.nav_gridView) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.gridview, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addItem2GridView();
        } else if (id == R.id.nav_imageButton) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.imagebutton, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_ImageButton();
        } else if (id == R.id.nav_imageView) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.imageview, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_ImageView();
        } else if (id == R.id.nav_linearLayout) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.linearlayout, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
        } else if (id == R.id.nav_listView) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.listview, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListItem2ListView();
        } else if (id == R.id.nav_progressBar) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.progressbar, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_Progress();
        } else if (id == R.id.nav_promptDialog) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.promptdialog, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_Prompt();
        } else if (id == R.id.nav_relativeLayout) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.relativelayout, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
        } else if (id == R.id.nav_tableLayout) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.tablelayout, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
        } else if (id == R.id.nav_toast) {
            ConstraintLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.toast, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            addListenerOnButton_Toast();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void addListenerOnButton_Progress() {
        button = findViewById(R.id.btn_Process);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(v.getContext());
                progressDialog.setCancelable(true);
                progressDialog.setMessage("File downloading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setProgress(0);
                progressDialog.setMax(100);
                progressDialog.show();

                progressBarStatus = 0;
                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressBarStatus < 100) {
                            progressBarStatus++;
                            if (progressBarStatus % 10 == 0)
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            progressBarHandle.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.setProgress(progressBarStatus);
                                }
                            });
                        }
                        if (progressBarStatus >= 100) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }
                }).start();
            }
        });
    }

    void addListenerOnButton_Alert() {
        button = findViewById(R.id.btn_Alert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alBuilder = new AlertDialog.Builder(context);
                alBuilder.setTitle("This is Title")
                        .setMessage("Click yes to exit")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alBuilder.create();
                alertDialog.show();
            }
        });
    }

    void addListenerOnButton_Prompt() {
        button = findViewById(R.id.btn_Prompt);
        editText = findViewById(R.id.et_TextResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt, null);
                AlertDialog.Builder alBuilder = new AlertDialog.Builder(context);
                alBuilder.setView(promptsView);
                final EditText userInput = promptsView.findViewById(R.id.et_prompt);
                alBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editText.setText(userInput.getText());
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alBuilder.create();
                alertDialog.show();
            }
        });
    }

    void addListenerOnButton_Toast() {
        button = findViewById(R.id.btn_Toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button is Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    void addListenerOnButton_ImageView() {
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.btn_imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag)
                    imageView.setImageResource(R.drawable.avatar2);
                else imageView.setImageResource(R.drawable.avatar);
                flag = !flag;
            }
        });
    }

    void addListenerOnButton_ImageButton() {
        imageButton = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ImageButton is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void addListItem2ListView() {
        listView = findViewById(R.id.listView);
        String[] values = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = listView.getItemAtPosition(itemPosition).toString();
                Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_LONG).show();
            }
        });

    }

    void addItem2GridView() {
        gridView = findViewById(R.id.gridView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
