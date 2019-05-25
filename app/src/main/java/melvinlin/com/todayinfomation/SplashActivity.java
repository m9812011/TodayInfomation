package melvinlin.com.todayinfomation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView mVideoView;
    private TextView mTvTimer;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = (FullScreenVideoView)findViewById(R.id.vv_play);
        mTvTimer = (TextView)findViewById(R.id.tv_splash_timer);
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //顯式啟動
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
        Uri uri = Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash);
        mVideoView.setVideoURI(uri);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });


        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳過");
            }
        });

        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();

    }
}
