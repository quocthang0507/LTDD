package vn.edu.itdlu.a1610207.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    static final String TAG = "1610207_SQLite";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "Note_Manager";
    static final String TABLE_NOTE = "NOTE";
    static final String COLUMN_NOTE_ID = "Note_ID";
    static final String COLUMN_NOTE_TITLE = "Note_Title";
    static final String COLUMN_NOTE_CONTENT = "Note_Content";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        String script = "CREATE TABLE " + TABLE_NOTE + "(" +
                COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NOTE_TITLE + " TEXT," +
                COLUMN_NOTE_CONTENT + " TEXT" + ")";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public void createDefaultNotesIfNeed() {
        int count = this.getNotesCount();
        if (count == 0) {
            Note note1 = new Note("Firstly see Android ListView", "laquocthang.blogspot.com");
            Note note2 = new Note("Learning Android SQLite", "laquocthang.blogspot.com");
            this.addNote(note1);
            this.addNote(note2);
        }
    }

    public void addNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.addNote ... " + note.getNoteTitle());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
        db.insert(TABLE_NOTE, null, values);
        db.close();
    }

    public Note getNote(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NOTE, new String[]{COLUMN_NOTE_ID, COLUMN_NOTE_TITLE, COLUMN_NOTE_CONTENT}, COLUMN_NOTE_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Note note = new Note(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        cursor.close();
        return note;
    }

    public List<Note> getAllNotes() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... ");
        List<Note> noteList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNodeID(Integer.parseInt(cursor.getString(0)));
                note.setNoteTitle((cursor.getString(1)));
                note.setNoteContent(cursor.getString(2));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return noteList;
    }

    public int getNotesCount() {
        Log.i(TAG, "MyDatabaseHelper.getNotesCount ...");
        String countQuery = " SELECT * FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int updateNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
        return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " = ?", new String[]{String.valueOf(note.getNodeID())});
    }

    public void deleteNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.deleteNote ... " + note.getNodeID());
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?", new String[]{String.valueOf(note.getNodeID())});
        db.close();
    }
}
