package com.robot.asus.ZenboDacing;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asus.robotframework.API.RobotCallback;
import com.asus.robotframework.API.RobotCmdState;
import com.asus.robotframework.API.RobotErrorCode;
import com.robot.asus.robotactivity.RobotActivity;

import org.json.JSONObject;

public class DanceActivity extends RobotActivity {
    private String TAG = "DanceActivity";
    private ConstraintLayout start;
    private String gender;
    private MediaPlayer music_cha = new MediaPlayer();

    public DanceActivity() {
        super(robotCallback, robotListenCallback);
    }

    public static RobotCallback robotCallback = new RobotCallback() {
        @Override
        public void onResult(int cmd, int serial, RobotErrorCode err_code, Bundle result) {
            super.onResult(cmd, serial, err_code, result);
        }

        @Override
        public void onStateChange(int cmd, int serial, RobotErrorCode err_code, RobotCmdState state) {
            super.onStateChange(cmd, serial, err_code, state);
        }

        @Override
        public void initComplete() {
            super.initComplete();

        }
    };

    public static RobotCallback.Listen robotListenCallback = new RobotCallback.Listen() {
        @Override
        public void onFinishRegister() {

        }

        @Override
        public void onVoiceDetect(JSONObject jsonObject) {

        }

        @Override
        public void onSpeakComplete(String s, String s1) {

        }

        @Override
        public void onEventUserUtterance(JSONObject jsonObject) {

        }

        @Override
        public void onResult(JSONObject jsonObject) {

        }

        @Override
        public void onRetry(JSONObject jsonObject) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);

        Intent intent = getIntent();
         gender = intent.getStringExtra("motion");
        Log.d(TAG, "gender: " + gender);

        start =(ConstraintLayout)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gender.equals("man")) {

                    music_cha.start();
                    manDance();

                } else if (gender.equals("lady")) {
                    ladyDance();

                }
        }});


    }

    @Override
    protected void onResume() {
        super.onResume();
        music_cha = MediaPlayer.create(this, R.raw.chacha);
    }

    @Override
    protected void onStop() {
        super.onStop();


    }
    @Override
    protected void onPause(){
        super.onPause();
        music_cha.stop();

    }


    private void musicPlay() {
        music_cha = MediaPlayer.create(this, R.raw.chacha);
        music_cha.start();
    }

    private void manDance(){
        robotAPI.robot.speak("Man");


    }
    private void ladyDance(){
        robotAPI.robot.speak("Lady");
    }
}
