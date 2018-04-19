package group6.fga.fsoft.com.mockproject_group6.controller;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

import group6.fga.fsoft.com.mockproject_group6.MainActivity;
import group6.fga.fsoft.com.mockproject_group6.database.DBManager;

public class Controller {
    public static final int STATE_LOAD_DATA = 0;
    public static final int STATE_SAVE_DATA = 1;
    public static final int STATE_DROP = 2;
    public static final int STATE_UPDATE_LESSON = 3;
    private static BaseState mCurrentState;
    private static SparseArray<BaseState> mStates;
    private MsgHandler mHandler;
    private MainActivity mMain;

    private DBManager mDBHelper;


    public Controller(MainActivity main) {
        mMain = main;
        mHandler = new MsgHandler();
        mDBHelper = new DBManager(mMain);
        initStates();
    }

    private static void transitionToState(int stateKey) {
        mCurrentState = mStates.get(stateKey);
    }

    private static void handleMsg(Message msg) {
        int state = msg.what;
        transitionToState(state);
        mCurrentState.handleMsg(msg);
    }

    private void initStates() {
        mStates = new SparseArray<>();
//        mStates.put(STATE_LOAD_DATA, new LoadDataState(this));
//        mStates.put(STATE_SAVE_DATA, new SaveDataState(this));
//        mStates.put(STATE_DROP, new DropState(this));
//        mStates.put(STATE_UPDATE_LESSON, new UpdateLessonState(this));
    }

    public void sendMsg(Message msg) {
        mHandler.sendMessage(msg);
    }

    MainActivity getMainActivity() {
        return mMain;
    }

    DBManager getDBHelper() {
        return mDBHelper;
    }

    private static class MsgHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            handleMsg(msg);
        }
    }
}
