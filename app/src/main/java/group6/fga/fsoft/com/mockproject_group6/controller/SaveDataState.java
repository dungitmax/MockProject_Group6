package group6.fga.fsoft.com.mockproject_group6.controller;

import android.os.Message;
import android.util.Log;

public class SaveDataState extends BaseState {
    public static final String TAG = SaveDataState.class.getName();

    public SaveDataState(Controller controller) {
        super(controller);
    }

    @Override
    public void handleMsg(Message msg) {
        Log.e("state",TAG);
    }
}
