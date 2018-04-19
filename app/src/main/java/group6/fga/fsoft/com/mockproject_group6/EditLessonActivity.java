package group6.fga.fsoft.com.mockproject_group6;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import group6.fga.fsoft.com.mockproject_group6.adapter.LessonAdapter;
import group6.fga.fsoft.com.mockproject_group6.model.entity.Lesson;

/**
 * Created by TungAnh on 4/19/18.
 */
public class EditLessonActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = EditLessonActivity.class.getName();
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mTvLessonName;
    private EditText mEditTextLesson;
    private Button mButtonOK;
    private Button mButtonCancel;
    private Lesson mLesson;
    private ImageView mIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name_lesson);
        initView();
        setAction();
    }

    private void setAction() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        mLesson = (Lesson) bundle.getSerializable("obj");
        mTvLessonName.setText(mLesson.getmName());
        mButtonOK.setOnClickListener(this);
        mButtonCancel.setOnClickListener(this);
        mIcon.setOnClickListener(this);
    }

    private void initView() {
        mTvLessonName = findViewById(R.id.tvLessonName);
        mEditTextLesson = findViewById(R.id.edtLessonName);
        mButtonOK = findViewById(R.id.btnOk1);
        mButtonCancel = findViewById(R.id.btnCancel1);
        mIcon = findViewById(R.id.icon_speechtotext);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk1) {
            String name = String.valueOf(mEditTextLesson.getText()).trim();
            if (name.length() == 0) {
                Toast.makeText(this, "Name Cannot Empty!", Toast.LENGTH_SHORT).show();
            } else {
                LessonAdapter lessonAdapter = new LessonAdapter(EditLessonActivity.this);
                boolean result = lessonAdapter.checkName(name);
                if (result == true) {
                    lessonAdapter.updateLesson(mLesson.getmId(), name);
                    Toast.makeText(this, "Name Edit Success!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Name Already Exist", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if (v.getId() == R.id.btnCancel1) {
            finish();
        }
        if (v.getId() == R.id.icon_speechtotext) {
            speechToText();
        }
    }

    private void speechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);

        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), getString(R.string.speech_not_supported), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent
                            .EXTRA_RESULTS);
                    mEditTextLesson.setText(result.get(0));
                }
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
