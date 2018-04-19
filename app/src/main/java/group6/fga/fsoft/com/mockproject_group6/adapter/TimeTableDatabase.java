package group6.fga.fsoft.com.mockproject_group6.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import group6.fga.fsoft.com.mockproject_group6.database.DBManager;
import group6.fga.fsoft.com.mockproject_group6.model.Contract;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Timetable;


public class TimeTableDatabase {
    SQLiteDatabase mSqLiteDatabase;
    private DBManager dbManager;

    public TimeTableDatabase(Context c) {
        dbManager = new DBManager(c);
        mSqLiteDatabase = dbManager.getWritableDatabase();
    }

    // Add
    public void addTimeTable(Timetable lessonName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.TIME_LESSON, lessonName.getmLessonName());
        contentValues.put(Contract.TIME_WEEK, lessonName.getmWeek());
        contentValues.put(Contract.TIME_POSITION, lessonName.getmPosition());
        mSqLiteDatabase.insert(Contract.TABLE_TIME, null, contentValues);
    }

    // Update
    public void updateTimeTable(Timetable timetable, int timeTableID) {
        ContentValues values = new ContentValues();
        values.put(Contract.TIME_ID, timetable.getmTimeTableID());
        values.put(Contract.TIME_LESSON, timetable.getmLessonName());
        values.put(Contract.TIME_WEEK, timetable.getmWeek());
        values.put(Contract.TIME_POSITION, timetable.getmPosition());
        // updating row
        mSqLiteDatabase.update(Contract.TABLE_TIME, values, Contract.TIME_ID + " = ?",
                new String[]{String.valueOf(timeTableID)});

    }

    // Delete
    public int delTimeTable(int id) {
        return mSqLiteDatabase.delete(Contract.TABLE_TIME, Contract.TIME_ID + "=?", new String[]{id + ""});
    }

    //Get TimeTable
    public Cursor getTimeTable(int i) {
        String query = "SELECT * FROM " + Contract.TABLE_TIME + " WHERE " + Contract.TIME_ID + "= ?";
        Cursor cursor = mSqLiteDatabase.rawQuery(query, new String[]{i + ""});
        return cursor;
    }

    //query week of table
    public Cursor getTimeTableOfWeek(int week) {
        String query = "SELECT * FROM " + Contract.TABLE_TIME + " WHERE " + Contract.TIME_WEEK + "= ?";
        Cursor cursor = mSqLiteDatabase.rawQuery(query, new String[]{week + ""});
        return cursor;
    }

}
