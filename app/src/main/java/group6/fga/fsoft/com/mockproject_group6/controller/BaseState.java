package group6.fga.fsoft.com.mockproject_group6.controller;

import android.content.DialogInterface;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import group6.fga.fsoft.com.mockproject_group6.MainActivity;
import group6.fga.fsoft.com.mockproject_group6.R;

public class BaseState {
    protected Controller mController;

    public BaseState(Controller controller) {
        mController = controller;
    }

    public void handleMsg(Message msg) {
        //......
    }

    protected void dialogEvents() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mController.getMainActivity());
        View mView = mController.getMainActivity().getLayoutInflater().inflate(R.layout.custom_dialog, null);
        TextView mTxtStartDay = mView.findViewById(R.id.txtFromDate);
        TextView mTxtToDay = mView.findViewById(R.id.txtToDate);
        CheckBox mCheckBox = mView.findViewById(R.id.checkBox);
        if (mCheckBox.isChecked()) {

        } else {

        }
        mTxtStartDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //from date
            }
        });
        mTxtToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to date

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
