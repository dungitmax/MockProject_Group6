package group6.fga.fsoft.com.mockproject_group6.model;

import android.provider.BaseColumns;

public class Contract implements BaseColumns {
    public static final String TABLE_LESSON = "LessonTable";
    public static final String LESSON_ID = "id";
    public static final String LESSON_NAME = "lessonName";

    public static final String TABLE_TIME = "TimeTable";
    public static final String TIME_ID = "id";
    public static final String TIME_WEEK = "week";
    public static final String TIME_LESSON = "lesson";
    public static final String TIME_YEAR = "year";
    public static final String TIME_POSITION = "position";
}
