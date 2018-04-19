package group6.fga.fsoft.com.mockproject_group6;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import group6.fga.fsoft.com.mockproject_group6.adapter.GridViewAdapter;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Lesson;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();
    private GridView mGridViewTimetable;
    private GridView mGridViewLessons;
    private GridViewAdapter mGridViewAdapter;
    private GridViewAdapter mLessonAdapter;
    private List<Object> mListTimetable;
    private List<Object> mListLesson;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DialogEvents();
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


    }

    private void DisplayDatePicker() {

    }

    private void initView() {
        ImageView r_bin = findViewById(R.id.r_bin);
        r_bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogEvents();
            }
        });
    }

    private void DialogEvents() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        final TextView mTxtStartDay = mView.findViewById(R.id.txtFromDate);
        final TextView mTxtToDay = mView.findViewById(R.id.txtToDate);
        CheckBox mCheckBox = mView.findViewById(R.id.checkBox);
        if (mCheckBox.isChecked()) {
            Toast.makeText(this, "isChecked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "NoCheck", Toast.LENGTH_SHORT).show();
        }
        mTxtStartDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //from date
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        mTxtStartDay.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        mTxtToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to date
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        mTxtToDay.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        alertDialogBuilder.setMessage("Đăng kí chu kì");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                /** xử lý đăng kí chu kì */
            }
        });
        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setView(mView);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
