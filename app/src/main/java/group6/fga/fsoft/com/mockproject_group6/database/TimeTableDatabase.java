package group6.fga.fsoft.com.mockproject_group6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import group6.fga.fsoft.com.mockproject_group6.model.Contract;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Timetable;


public class TimeTableDatabase {
    SQLiteDatabase mSqLiteDatabase;
    DBManager dbManager;

    public TimeTableDatabase(Context c, DBManager dbManager) {
        mSqLiteDatabase = dbManager.getWritableDatabase();
        dbManager = new DBManager(c);
    }

    // Add
    public void addTimeTable(Timetable timetable) {
        mSqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.TIME_LESSON, timetable.getmLessonName());
        contentValues.put(Contract.TIME_WEEK, timetable.getmWeek());
        contentValues.put(Contract.TIME_YEAR, timetable.getmYear());
        contentValues.put(Contract.TIME_POSITION, timetable.getmPosition());
        mSqLiteDatabase.insert(Contract.TABLE_TIME, null, contentValues);
        mSqLiteDatabase.close();
    }

    // Update
    public void updateTimeTable(Timetable timetable) {
        mSqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.TIME_LESSON, timetable.getmLessonName());
        values.put(Contract.TIME_WEEK, timetable.getmWeek());
        values.put(Contract.TIME_YEAR, timetable.getmYear());
        values.put(Contract.TIME_POSITION, timetable.getmPosition());
        // updating row
        mSqLiteDatabase.update(Contract.TABLE_TIME, values, Contract.TIME_ID + " = ?",
                new String[]{String.valueOf(timetable.getmTimeTableID())});
    }

    // Delete TimeTable
    public void deleteTimeTable(Timetable timetable) {
        mSqLiteDatabase = dbManager.getWritableDatabase();
        mSqLiteDatabase.delete(Contract.TABLE_TIME, Contract.TIME_ID + " = ?",
                new String[]{String.valueOf(timetable.getmTimeTableID())});
        mSqLiteDatabase.close();
    }

//    //Get TimeTable
//    public Cursor getTimeTable(int i) {
//        String query = "SELECT * FROM " + Contract.TABLE_TIME + " WHERE " + Contract.TIME_ID + "= ?";
//        Cursor cursor = mSqLiteDatabase.rawQuery(query, new String[]{i + ""});
//        return cursor;
//    }

    //Get list ALl Table
    public List<Timetable> getAllTimetable() {
        List<Timetable> listTimeTable = new ArrayList<>();
        String queryTable = " SELECT * FROM " + Contract.TABLE_LESSON;
        mSqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = mSqLiteDatabase.rawQuery(queryTable, null);

        if (cursor.moveToFirst()) {
            do {
                Timetable timetable = new Timetable();
                timetable.setmTimeTableID(cursor.getInt(0));
                timetable.setmWeek(cursor.getInt(1));
                timetable.setmLessonName(cursor.getString(2));
                timetable.setmYear(cursor.getInt(3));
                timetable.setmPosition(cursor.getInt(4));
                listTimeTable.add(timetable);
            } while (cursor.moveToNext());
        }
        cursor.close();
        mSqLiteDatabase.close();
        return listTimeTable;

    }

//    //query week of table
//    public Cursor getTimeTableOfWeek(int week, int year) {
//        String query = "SELECT * FROM " + Contract.TABLE_TIME + " WHERE " + Contract.TIME_WEEK + "= ?" + " AND " + Contract.TIME_YEAR + "= ?";
//
//        Cursor cursor = mSqLiteDatabase.rawQuery(query, new String[]{week + "", year + ""});
//        return cursor;
//    }

    // quẻy by week
    public List<Timetable> getTimeTableByWeek(int week, int year) {
        List<Timetable> listTimeTableByWeek = new ArrayList<>();
        String query = "SELECT * FROM " + Contract.TABLE_TIME + " WHERE " + Contract.TIME_WEEK + "= ?" + " AND " + Contract.TIME_YEAR + "= ?";
        mSqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = mSqLiteDatabase.rawQuery(query, new String[]{week + "", year + ""});

        if (cursor.moveToFirst()) {
            do {
                Timetable timetable = new Timetable();
                timetable.setmTimeTableID(cursor.getInt(0));
                timetable.setmWeek(cursor.getInt(1));
                timetable.setmLessonName(cursor.getString(2));
                timetable.setmYear(cursor.getInt(3));
                timetable.setmPosition(cursor.getInt(4));
                listTimeTableByWeek.add(timetable);
            } while (cursor.moveToNext());
        }
        cursor.close();
        mSqLiteDatabase.close();
        return listTimeTableByWeek;

    }

}
