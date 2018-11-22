package vn.edu.itdlu.a1610207.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {

    static final int MODE_CREATE = 1;
    static final int MODE_EDIT = 2;
    Note note;
    int mode;
    EditText textTitle;
    EditText textContent;
    boolean needRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);
        map();
    }

    void map() {
        this.textTitle = findViewById(R.id.text_note_title);
        this.textContent = findViewById(R.id.text_note_content);
        textTitle.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        textContent.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        Intent intent = this.getIntent();
        this.note = (Note) intent.getSerializableExtra("note");
        if (note == null) {
            this.mode = MODE_CREATE;
        } else {
            this.mode = MODE_EDIT;
            this.textTitle.setText(note.getNoteTitle());
            this.textContent.setText(note.getNoteContent());
        }
    }

    public void buttonSaveClicked(View view) {
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        String title = this.textTitle.getText().toString();
        String content = this.textContent.getText().toString();
        if (title.equals("") || content.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter title & content", Toast.LENGTH_LONG).show();
            return;
        }
        if (mode == MODE_CREATE) {
            this.note = new Note(title, content);
            db.addNote(note);
        } else {
            this.note.setNoteTitle(title);
            this.note.setNoteContent(content);
            db.updateNote(note);
        }
        this.needRefresh = true;
        this.onBackPressed();
    }

    public void buttonCancelClicked(View view) {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("needRefresh", needRefresh);
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}
