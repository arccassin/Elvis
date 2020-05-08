package com.example.elvis;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    TextView tvTrackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTrackName = findViewById(R.id.tvTrackName);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.elvis_tutty_frutty);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.elvis_rocknroll);
    }

    public void onClickStart(View view) {
        if (mediaPlayer2.isPlaying()) {
            mediaPlayer2.pause();
        }
        mediaPlayer1.start();
        tvTrackName.setText(R.string.tvTrackName_elvis_tutti);
    }

    public void onClickNext(View view) {
        if (mediaPlayer1.isPlaying()) {
            mediaPlayer1.pause();
            mediaPlayer2.start();
            tvTrackName.setText(R.string.tvTrackName_elvis_rocknroll);
        } else if (mediaPlayer2.isPlaying()) {
            mediaPlayer2.pause();
            mediaPlayer1.start();
            tvTrackName.setText(R.string.tvTrackName_elvis_tutti);
        }

    }
}
