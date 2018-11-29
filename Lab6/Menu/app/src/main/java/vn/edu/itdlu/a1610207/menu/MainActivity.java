package vn.edu.itdlu.a1610207.menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    ArrayList<String> s;
    ArrayAdapter<String> adapter;
    Button button;
    Intent intent;

    ActionMode mActionMode;

    //Xử lý menu hành động theo ngữ cảnh
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_action, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_del:
                    Toast.makeText(getApplicationContext(), "Bạn đã nhấn delete", Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addItem2ListView();

        addContextMenu();
        addActionMode();
        addMultiChoice_ActionMode();
        addPopupMenu();
    }

    //Thêm actionmode vào
    void addActionMode() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode == null) {
                    mActionMode = startActionMode(mActionModeCallback);
                    view.setSelected(true);
                    return true;
                }
                return false;
            }
        });
    }

    void addMultiChoice_ActionMode() {
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                listView.getChildAt(position).setBackgroundColor(Color.GRAY);
                if (listView.getCheckedItemCount() == 1)
                    mode.setSubtitle("1 item selected");
                else mode.setSubtitle(listView.getCheckedItemCount() + "items selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_action, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_del:
                        for (int i = listView.getChildCount() - 1; i >= 0; i--) {
                            if (listView.isItemChecked(i)) {
                                listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                                s.remove(i);
                                adapter.notifyDataSetChanged();
                            }
                        }
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    void addItem2ListView() {
        listView = findViewById(R.id.context_menu);
        s = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String temp = "Row " + i;
            s.add(temp);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
        listView.setAdapter(adapter);
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
        getMenuInflater().inflate(R.menu.menu_hanhdong, menu);
        return true;
    }

    //Xử lý menu hành động tại đây
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_about) {
            String info = "Thông tin ứng dụng\r\n\nHọ và tên: La Quốc Thắng\r\nMSSV: 1610207\r\nLớp: CTK40";
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("About");
            builder.setMessage(info);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create();
            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }

    //Xử lý menu tùy chọn tại đây
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(), "Bạn đã nhấn vào share", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(), "Bạn đã nhấn vào send", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_delete) {
            Toast.makeText(getApplicationContext(), "Bạn đã nhấn vào delete", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_recovery) {
            Toast.makeText(getApplicationContext(), "Bạn đã nhấn vào recovery", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Xử lý menu ngữ cảnh tại đây
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(contextMenu, view, info);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ngucanh, contextMenu);
    }

    //Thêm contextmenu vào
    void addContextMenu() {
        registerForContextMenu(listView);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position;
        String delItem = s.get(pos);
        switch (item.getItemId()) {
            case R.id.context_copy:
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn copy", Toast.LENGTH_LONG).show();
                break;
            case R.id.context_cut:
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn cut", Toast.LENGTH_LONG).show();
                break;
            case R.id.context_paste:
                Toast.makeText(getApplicationContext(), "Bạn đã nhấn paste", Toast.LENGTH_LONG).show();
                break;
            case R.id.context_delete:
                s.remove(pos);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Deleted " + delItem + " at row " + pos, Toast.LENGTH_LONG);
                break;
        }
        return super.onContextItemSelected(item);
    }

    //Thêm popup menu
    void addPopupMenu() {
        button = findViewById(R.id.btn_show_popup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.popup_browser:
                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.vn"));
                                startActivity(intent);
                                return true;
                            case R.id.popup_thoat:
                                finish();
                                //return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
}