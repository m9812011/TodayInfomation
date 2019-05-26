package melvinlin.com.todayinfomation;


import android.os.Handler;

/**
 * 1.時時回調 這個時間的什麼時間 倒數計時到幾秒 (觀察者設計模式)
 * 2.支持動態傳入總時間
 * 3.每過一秒總秒數減一
 * 4.計時為0時，要回調完成的狀態
 */
public class CustomCountDownTimer implements Runnable {

    private int time;
    private int countDowntime;
    private ICountDownHandler countDownHandler;
    private Handler handler;
    private boolean isRun;


    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler) {
        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
    }

    //實現的具體邏輯
    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                countDownHandler.onTicker(countDowntime);
            }

            if (countDowntime == 0) {
                cancel();
                if (countDownHandler != null) {
                    countDownHandler.onFinish();
                }
            } else {
                countDowntime = time--;
                handler.postDelayed(this, 1000);
            }
        }
    }

    //開始倒計時
    public void start() {
        isRun = true;
        handler.post(this);

    }

    //跳出循環 終止
    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    //觀察者回調接口 (IOC 數據回調)
    public interface ICountDownHandler {
        //倒數時回調
        void onTicker(int time);

        //完成時回調
        void onFinish();
    }


}
