package group6.fga.fsoft.com.mockproject_group6.controller;

import android.os.Message;

public class BaseState {
    protected Controller mController;

    public BaseState(Controller controller) {
        mController = controller;
    }

    public void handleMsg(Message msg) {
        //......
    }

}
