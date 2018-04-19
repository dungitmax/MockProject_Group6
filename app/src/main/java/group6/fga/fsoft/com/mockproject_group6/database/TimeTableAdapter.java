package group6.fga.fsoft.com.mockproject_group6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import group6.fga.fsoft.com.mockproject_group6.model.Contract;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Timetable;


public class TimeTableAdapter {
    SQLiteDatabase mSqLiteDatabase;
    private DBManager dbManager;

    public TimeTableAdapter(Context c) {
        dbManager = new DBManager(c);
        mSqLiteDatabase = dbManager.getWritableDatabase();
    }

    // Add
    public void addTimeTable(String lessonName, int week, int position) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.TIME_LESSON, lessonName);
        contentValues.put(Contract.TIME_WEEK, week);
        contentValues.put(Contract.TIME_POSITION, position);
        mSqLiteDatabase.insert(Contract.TABLE_TIME, null, contentValues);
    }

    // Update
    public boolean updateTimeTable(ArrayList<Timetable> timeTableArrayList) {
        mSqLiteDatabase.delete(Contract.TABLE_TIME, null, null);
        for (Timetable timeTable : timeTableArrayList) {
            String lessonName = timeTable.getmLessonName();
            int week = timeTable.getmWeek();
            int position = timeTable.getmPosition();
            addTimeTable(lessonName, week, position);
        }
        return true;
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
