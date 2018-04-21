package group6.fga.fsoft.com.mockproject_group6.model.entity;

/**
 * Created by TungAnh on 4/16/18.
 */
public class Timetable {
    private int mTimeTableID;
    private String mLessonName;
    private int mWeek;
    private int mYear;
    private int mPosition;

    public Timetable() {

    }

    public Timetable(int mTimeTableID, String mLessonName, int mWeek, int mYear, int mPosition) {
        this.mTimeTableID = mTimeTableID;
        this.mLessonName = mLessonName;
        this.mWeek = mWeek;
        this.mYear = mYear;
        this.mPosition = mPosition;
    }

    public int getmTimeTableID() {
        return mTimeTableID;
    }

    public void setmTimeTableID(int mTimeTableID) {
        this.mTimeTableID = mTimeTableID;
    }

    public String getmLessonName() {
        return mLessonName;
    }

    public void setmLessonName(String mLessonName) {
        this.mLessonName = mLessonName;
    }

    public int getmWeek() {
        return mWeek;
    }

    public void setmWeek(int mWeek) {
        this.mWeek = mWeek;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }
}
