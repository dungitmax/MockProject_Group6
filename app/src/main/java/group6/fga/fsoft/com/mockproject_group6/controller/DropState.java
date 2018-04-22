package group6.fga.fsoft.com.mockproject_group6.controller;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import group6.fga.fsoft.com.mockproject_group6.R;
import group6.fga.fsoft.com.mockproject_group6.database.DBManager;
import group6.fga.fsoft.com.mockproject_group6.database.TimeTableDatabase;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Timetable;

public class DropState extends BaseState {
    public static final int FROM_TIMETABLE_TO_TIMETABLE = -1;
    public static final int FROM_LESSONS_TO_TIMETABLE = 0;
    public static final int DELETE_LESSON = 1;
    public static final int REPLACE_LESSON = 2;
    public static final int ADD_LESSON_TO_TIMETABLE = 3;
    public static final String TAG = DropState.class.getName();
    Date date1, date2;
    DBManager mDbManager;


    public DropState(Controller controller) {
        super(controller);
    }

    @Override
    public void handleMsg(Message msg) {
        Log.e("state", TAG);

        if (msg.arg1 == REPLACE_LESSON) {
            Log.e("action", "REPLACE_LESSON");
            if (msg.arg2 == FROM_TIMETABLE_TO_TIMETABLE) {

            } else if (msg.arg2 == FROM_LESSONS_TO_TIMETABLE) {
                // hien thi dialog dang ky chu ky
            }

        } else if (msg.arg1 == DELETE_LESSON) {
            Log.e("action", "DELETE_LESSON");

        } else if (msg.arg1 == ADD_LESSON_TO_TIMETABLE) {
            Log.e("action", "ADD_LESSON_TO_TIMETABLE");
            // hien thi dialog dang ky chu ky
            dialogEvents();

        }

    }

    protected void dialogEvents() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mController.getMainActivity());
        View mView = mController.getMainActivity().getLayoutInflater().inflate(R.layout.custom_dialog, null);
        final TextView mTxtStartDay = mView.findViewById(R.id.txtFromDate);
        final TextView mTxtToDay = mView.findViewById(R.id.txtToDate);
        final CheckBox mCheckBox = mView.findViewById(R.id.checkBox);
        if (mCheckBox.isChecked()) {
            /**Xử lý check ở đây nhé*/

        } else {
            /** ẩn textView To ngày*/

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
                        date1 = myCalendar.getTime();
                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        mTxtStartDay.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(mController.getMainActivity(), date, myCalendar
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
                        date2 = myCalendar.getTime();
                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        mTxtToDay.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(mController.getMainActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        alertDialogBuilder.setMessage("Đăng kí chu kì");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                /** xử lý đăng kí chu kì */
                Calendar now = Calendar.getInstance();
                now.setTime(date1);
                int week1 = now.get(Calendar.WEEK_OF_YEAR);
                now.setTime(date2);
                int week2 = now.get(Calendar.WEEK_OF_YEAR);
                ArrayList<Integer> mListOfWeek = new ArrayList<>();
                for (int i = week1; i <= week2; i++) {
                    mListOfWeek.add(i);
                    TimeTableDatabase timeTableDatabase = new TimeTableDatabase(mController.getMainActivity(), mDbManager);
                    //fix cứng name.
                    String name = "Math";
                    Timetable timetable = new Timetable(name, mListOfWeek.get(i));
                    // đã lấy đc danh sách tuần từ tuần A -> B ở trên . Bây giờ chỉ cần add list đấy vào database
                    // + vs cái môn học cần add theo chu kì là đc.
                    //add list week.
                    timeTableDatabase.addTimeTable(timetable);
                }
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
