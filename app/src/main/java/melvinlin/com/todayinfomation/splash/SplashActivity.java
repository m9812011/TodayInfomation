package melvinlin.com.todayinfomation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import melvinlin.com.todayinfomation.base.BaseActivity;
import melvinlin.com.todayinfomation.main.MainActivity;
import melvinlin.com.todayinfomation.R;
import melvinlin.com.todayinfomation.base.ViewInject;

@ViewInject(mainLayoutId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    @BindView(R.id.vv_play)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;

    private ISplashActivityContract.IPresenter timerPresenter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        initTimerPresenter();
//        initListener();
//        initVideo();
//    }

    /**
     * 模板方法 設計模式
     */
    @Override
    public void afterBindView() {
        initTimerPresenter();
        initListener();
        initVideo();
    }

    //
    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresenter(SplashActivity.this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash);
        mVideoView.setVideoURI(uri);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void initListener() {
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //顯式啟動
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    public void setTvTimer(String s) {
        mTvTimer.setText(s);
    }

}
