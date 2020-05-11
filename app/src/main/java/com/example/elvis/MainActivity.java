package com.example.elvis;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    TextView tvTrackName;
    int fieldsPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTrackName = findViewById(R.id.tvTrackName);

    }

    public void onClickStart(View view) {
        if (mediaPlayer == null){
            startNextMediaPlayer();
        } else {
            mediaPlayer.start();
        }

    }

    public void onClickNext(View view) {
        mediaPlayer.stop();
        startNextMediaPlayer();
    }

    public void startNextMediaPlayer(){
        Field field = getNextRowField();
        if (field != null) {
            try {
                mediaPlayer = MediaPlayer.create(this, field.getInt(null));
                mediaPlayer.start();
                String text = field.getName() + " is playing";
                tvTrackName.setText(text);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Field getNextRowField() {
        Field[] fields = R.raw.class.getFields();
        Field field;
        field = fields[fieldsPos];
        fieldsPos = (fieldsPos == fields.length - 1) ? 0 : fieldsPos + 1;
        return field;

    }

    public void onClickPause(View view) {
        mediaPlayer.pause();
    }
}
