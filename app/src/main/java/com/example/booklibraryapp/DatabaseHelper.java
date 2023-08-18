package com.example.booklibraryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    //Database Information
    private static final String DATABASE_NAME = "BookLibrary.db";
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Table name
    public static final String TABLE_NAME = "my_library";
    //Table column
    public static final String COlUMN_ID = "id";
    public static final String COLUMN_TITLE = "book_title";
    public static final String COLUMN_AUTHOR = "book_author";
    public static final String COLUMN_PAGES = "book_pages";
//    private SQLiteDatabase database;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //Creating table query 1
//    private static final String CREATE_TABLE = String.format(
//            "CREATE TABLE %s (" +
//                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    "%s TEXT, " +
//                    "%s TEXT, " +
//                    "%s INTEGER)",
//            TABLE_NAME, COlUMN_ID, COLUMN_TITLE, COLUMN_AUTHOR, COLUMN_PAGES
//    );

//    Creating table query 2
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COlUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " INTEGER);";
        db.execSQL(query);
    }
    //Creating table query 3
//    private static final String C = "create table " + TABLE_NAME + "(" +
//            COlUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            COLUMN_TITLE + " TEXT NOT NULL, " +
//            COLUMN_AUTHOR + " TEXT NOT NULL, "+
//            COLUMN_PAGES + " INTEGER);";

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, AUTHOR TEXT, PAGES INTEGER)");
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add data 1
//    public boolean insertData(String title, String author, String pages) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_TITLE,title);
//        contentValues.put(COLUMN_AUTHOR,author);
//        contentValues.put(COLUMN_PAGES,pages);
//        long result = db.insert(TABLE_NAME,null ,contentValues);
//        if(result == -1)
//            return false;
//        else
//            return true;
//    }

    //Add 2
    void addBook(String title, String author, int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //change curor get data
//    public Cursor getAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
//        return res;
//    }

    //update data 1
//    public boolean updateData(String id,String title,String author,String pages) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COlUMN_ID,id);
//        contentValues.put(COLUMN_TITLE,title);
//        contentValues.put(COLUMN_AUTHOR,author);
//        contentValues.put(COLUMN_PAGES,pages);
//        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
//        return true;
//    }

    //update 2
    void updateData(String row_id, String title, String author, String pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    //deleta data 1
//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
//    }

    //delete data
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

//    void deleteAllData(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_NAME);
//    }

}


