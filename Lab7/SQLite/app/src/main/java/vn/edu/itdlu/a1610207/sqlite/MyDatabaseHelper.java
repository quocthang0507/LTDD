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
	static final String DATABASE_NAME = "Note_Manager"; //Tên CSDL
	static final String TABLE_NOTE = "NOTE";    //Tên bảng
	static final String COLUMN_NOTE_ID = "Note_ID";
	static final String COLUMN_NOTE_TITLE = "Note_Title";
	static final String COLUMN_NOTE_CONTENT = "Note_Content";
	
	public MyDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);  //Truyền các tham số vào lớp cha để tạo database
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {   //Tạo bảng
		Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
		String script = "CREATE TABLE " + TABLE_NOTE + "(" +
				COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," +
				COLUMN_NOTE_TITLE + " TEXT," +
				COLUMN_NOTE_CONTENT + " TEXT" + ")";
		db.execSQL(script); //Thực hiện các câu tạo bảng mà không phải là select
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
	
	//Thêm một ghi chú vào CSDL
	public void addNote(Note note) {
		Log.i(TAG, "MyDatabaseHelper.addNote ... " + note.getNoteTitle());
		SQLiteDatabase db = this.getWritableDatabase(); //Mở kết nối để ghi dữ liệu vào database
		ContentValues values = new ContentValues(); //Đưa nội dung của giá trị vào bảng
		values.put(COLUMN_NOTE_TITLE, note.getNoteTitle()); //Đặt giá trị theo key được chỉ định
		values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
		db.insert(TABLE_NOTE, null, values);    //Thêm value vào bảng TABLE_NOTE
		db.close(); //Đóng kết nối
	}
	
	//Cập nhật ghi chú
	public int updateNote(Note note) {
		Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle());
		SQLiteDatabase db = this.getWritableDatabase(); //Mở kết nối để ghi
		ContentValues values = new ContentValues();
		values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
		values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
		//Update TABLE_NOTE set NOTE = @NOTE where NOTE_ID = @NOTE.getID
		//return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + "= note.getID", null);
		return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + " = ?",
				new String[]{String.valueOf(note.getNodeID())});
	}
	
	//Lấy/ Tìm một ghi chú theo id
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
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null); //Tạo một con trỏ chứa toàn bộ kết quả của câu truy vấn
		if (cursor.moveToFirst()) { //Nếu cursor không trống
			do {
				Note note = new Note(); //Tạo một ghi chú trống
				note.setNodeID(Integer.parseInt(cursor.getString(0)));  //Thêm lần lượt các cột của con trỏ hiện tại vào note
				note.setNoteTitle((cursor.getString(1)));
				note.setNoteContent(cursor.getString(2));
				noteList.add(note); //Thêm vào danh sách
			} while (cursor.moveToNext());  //Đi đến hết cursor
		}
		cursor.close();
		db.close();
		return noteList;
	}
	
	//Đếm số lượng ghi chú có trong bảng
	public int getNotesCount() {
		Log.i(TAG, "MyDatabaseHelper.getNotesCount ...");
		String countQuery = " SELECT * FROM " + TABLE_NOTE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}
	
	//Xóa một ghi chú
	public void deleteNote(Note note) {
		Log.i(TAG, "MyDatabaseHelper.deleteNote ... " + note.getNodeID());
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?", new String[]{String.valueOf(note.getNodeID())});
		db.close();
	}
}
