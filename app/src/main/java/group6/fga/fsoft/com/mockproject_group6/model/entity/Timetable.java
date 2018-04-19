package group6.fga.fsoft.com.mockproject_group6.model.entity;

/**
 * Created by TungAnh on 4/16/18.
 */
public class Timetable {
    private int mLessonID;
    private String mLessonName;
    private int mWeek;
    private int mPosition;

    public Timetable(int mLessonID, String mLessonName, int mWeek, int mPosition) {
        this.mLessonID = mLessonID;
        this.mLessonName = mLessonName;
        this.mWeek = mWeek;
        this.mPosition = mPosition;
    }

    public int getmLessonID() {
        return mLessonID;
    }

    public void setmLessonID(int mLessonID) {
        this.mLessonID = mLessonID;
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
                "mLessonID=" + mLessonID +
                ", mLessonName='" + mLessonName + '\'' +
                ", mWeek=" + mWeek +
                ", mPosition=" + mPosition +
                '}';
    }
}
