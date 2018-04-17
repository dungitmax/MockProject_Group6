package group6.fga.fsoft.com.mockproject_group6.model;

import com.tunganh.finalmockproject.model.entity.Lesson;
import com.tunganh.finalmockproject.model.entity.TimetableCell;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Created by TungAnh on 4/16/18.
 */
public class Model {
    public static final String UPDATE_TIMETABLE = "UPDATE_TIMETABLE";
    public static final String UPDATE_LESSON_LIST = "UPDATE_LESSON_LIST";

    private ArrayList<Lesson> mLessonsList;
    private ArrayList<TimetableCell> mTimetableCellsList;

    private boolean mEdittingLesson;
    private PropertyChangeSupport mPropertyChangeSupport;

    public Model() {
        mPropertyChangeSupport = new PropertyChangeSupport(this);
    }

    public ArrayList<Lesson> getLessonsList() {
        return mLessonsList;
    }

    public void setLessonsList(
        ArrayList<Lesson> lessonsList) {
        mLessonsList = lessonsList;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        mPropertyChangeSupport = propertyChangeSupport;
    }

    public ArrayList<TimetableCell> getTimetableCellsList() {
        return mTimetableCellsList;
    }

    public void setTimetableCellsList(
        ArrayList<TimetableCell> timetableCellsList) {
        mTimetableCellsList = timetableCellsList;
    }

    public boolean isEdittingLesson() {
        return mEdittingLesson;
    }

    public void setEdittingLesson(boolean edittingLesson) {
        mEdittingLesson = edittingLesson;
    }
}
