//// Activity CRUD
//package com.example.booklibraryapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.SQLException;
//import androidx.appcompat.app.AppCompatActivity;
//
//
//public class DBManager extends AppCompatActivity {
//    private DatabaseHelper dbHelper;
//
//    private Context context;
//
//    private SQLiteDatabase database;
//
//    public DBManager(Context c) {
//        context = c;
//    }
//
//    public DBManager open() throws SQLException {
//        dbHelper = new DatabaseHelper(context);
//        database = dbHelper.getWritableDatabase();
//        return this;
//    }
//
//    public void close() {
//        dbHelper.close();
//    }
//
//    public void insert(String title, String author, int page) {
//        ContentValues contentValue = new ContentValues();
//        contentValue.put(DatabaseHelper.COLUMN_TITLE, title);
//        contentValue.put(DatabaseHelper.COLUMN_AUTHOR, author);
//        contentValue.put(DatabaseHelper.COLUMN_PAGES, page);
//        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
//    }
//
//    public Cursor fetch() {
//        String[] columns = new String[] { DatabaseHelper.COlUMN_ID, DatabaseHelper.COLUMN_TITLE, DatabaseHelper.COLUMN_AUTHOR, DatabaseHelper.COLUMN_PAGES};
//        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }
//
//    public int update(long id, String title, String author, String pages) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.COLUMN_TITLE, title);
//        contentValues.put(DatabaseHelper.COLUMN_AUTHOR, author);
//        contentValues.put(DatabaseHelper.COLUMN_PAGES, pages);
//        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COlUMN_ID + " = " + id, null);
//        return i;
//    }
//
//    public void delete(long _id) {
//        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COlUMN_ID+ "=" + _id, null);
//    }
//
//}
