package group6.fga.fsoft.com.mockproject_group6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import group6.fga.fsoft.com.mockproject_group6.adapter.GridViewAdapter;
import group6.fga.fsoft.com.mockproject_group6.database.DBManager;
import group6.fga.fsoft.com.mockproject_group6.adapter.LessonAdapter;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Lesson;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "letandung";

    private GridView mGridViewTimetable;
    private GridView mGridViewLessons;
    private GridViewAdapter mGridViewAdapter;
    private GridViewAdapter mLessonAdapter;
    private List<Object> mListTimetable;
    private List<Object> mListLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListLesson = new ArrayList<>();
        mListTimetable = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            mListLesson.add(new Lesson(""));
        }

        mListTimetable.add("");
        mListTimetable.add("Monday");
        mListTimetable.add("Tuesday");
        mListTimetable.add("Wednesday");
        mListTimetable.add("Thursday");
        mListTimetable.add("Friday");
        mListTimetable.add("Saturday");

        for (int i = 1; i <= 6; i++) {
            mListTimetable.add("Lesson " + i);
            for (int j = 1; j <= 6; j++) {
                mListTimetable.add(new Lesson("English"));
            }
        }

        mGridViewAdapter = new GridViewAdapter(this, mListTimetable, GridViewAdapter.GRID_TIMETABLE);
        mLessonAdapter = new GridViewAdapter(this, mListLesson, GridViewAdapter.GRID_LESSON);

        mGridViewTimetable = findViewById(R.id.grid_view_timetable);
        mGridViewLessons = findViewById(R.id.grid_view_lessons);
        mGridViewTimetable.setAdapter(mGridViewAdapter);
        mGridViewLessons.setAdapter(mLessonAdapter);
//
        DBManager dbManager = new DBManager(this);
        LessonAdapter mLessonAdapter = new LessonAdapter(this);
        Lesson lesson = new Lesson("Toan");
        mLessonAdapter.addLesson(lesson);


    }
}
