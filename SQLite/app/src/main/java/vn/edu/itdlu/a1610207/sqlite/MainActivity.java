package vn.edu.itdlu.a1610207.sqlite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int MENU_ITEM_VIEW = 111;
    static final int MENU_ITEM_EDIT = 222;
    static final int MENU_ITEM_CREATE = 333;
    static final int MENU_ITEM_DELETE = 444;
    static final int MY_REQUEST_CODE = 1000;
    final List<Note> noteList = new ArrayList<Note>();
    ListView listView;
    ArrayAdapter<Note> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
    }

    void map() {
        listView = findViewById(R.id.listView);
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.createDefaultNotesIfNeed();
        List<Note> list = db.getAllNotes();
        this.noteList.addAll(list);
        this.listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.noteList);
        this.listView.setAdapter(this.listViewAdapter);
        registerForContextMenu(this.listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Select the action");
        menu.add(0, MENU_ITEM_VIEW, 0, "View Note");
        menu.add(0, MENU_ITEM_CREATE, 1, "Create Note");
        menu.add(0, MENU_ITEM_EDIT, 2, "Edit Note");
        menu.add(0, MENU_ITEM_DELETE, 4, "Delete Note");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Note selectedNote = (Note) this.listView.getItemAtPosition(info.position);
        if (item.getItemId() == MENU_ITEM_VIEW) {
            Toast.makeText(getApplicationContext(), selectedNote.getNoteContent(), Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == MENU_ITEM_CREATE) {
            Intent intent = new Intent(this, AddEditNoteActivity.class);
            this.startActivityForResult(intent, MY_REQUEST_CODE);
        } else if (item.getItemId() == MENU_ITEM_EDIT) {
            Intent intent = new Intent(this, AddEditNoteActivity.class);
            intent.putExtra("note", selectedNote);
            this.startActivityForResult(intent, MY_REQUEST_CODE);
        } else if (item.getItemId() == MENU_ITEM_DELETE) {
            new AlertDialog.Builder(this).
                    setMessage(selectedNote.getNoteTitle() + ". Are you sure want to delete?")
                    .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteNote(selectedNote);
                }
            }).setNegativeButton("No", null).show();
        } else {
            return false;
        }
        return true;
    }

    void deleteNote(Note note) {
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.deleteNote(note);
        this.noteList.remove(note);
        this.listViewAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            boolean needRefresh = data.getBooleanExtra("needRefresh", true);
            if (needRefresh) {
                this.noteList.clear();
                MyDatabaseHelper db = new MyDatabaseHelper(this);
                List<Note> list = db.getAllNotes();
                this.noteList.addAll(list);
                this.listViewAdapter.notifyDataSetChanged();
            }
        }
    }
}
