package melvinlin.com.todayinfomation;


import android.util.Log;

import melvinlin.com.todayinfomation.mvp.ISplashActivityContract;
import melvinlin.com.todayinfomation.mvp.base.BaseMvpPresenter;
import melvinlin.com.todayinfomation.mvp.IMvpView;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

//    private SplashActivity mActivity;
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }

//    public SplashTimerPresenter(IMvpView view) {
//        super(view);
//    }

    //TODO:
//    public SplashTimerPresenter(SplashActivity activity) {
//        this.mActivity = activity;
//    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳過");
            }
        });

        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }

//    @Override
//    protected IMvpView getEmptyView() {
//        return null;
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    /**
     * 防止 空指針異常(代優化)
     * @return
     */
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
