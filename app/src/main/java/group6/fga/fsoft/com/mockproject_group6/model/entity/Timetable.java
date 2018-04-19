package group6.fga.fsoft.com.mockproject_group6.model.entity;

/**
 * Created by TungAnh on 4/16/18.
 */
public class Timetable {
    private int mTimeTableID;
    private String mLessonName;
    private int mWeek;
    private int mPosition;

    public Timetable(int mTimeTableID, String mLessonName, int mWeek, int mPosition) {
        this.mTimeTableID = mTimeTableID;
        this.mLessonName = mLessonName;
        this.mWeek = mWeek;
        this.mPosition = mPosition;
    }
    public Timetable( String mLessonName, int mWeek, int mPosition) {
        this.mLessonName = mLessonName;
        this.mWeek = mWeek;
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

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "mTimeTableID=" + mTimeTableID +
                ", mLessonName='" + mLessonName + '\'' +
                ", mWeek=" + mWeek +
                ", mPosition=" + mPosition +
                '}';
    }
}
